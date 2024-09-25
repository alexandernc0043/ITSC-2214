import itsc2214.*; // not needed now, but you might in your projects

import java.util.Arrays;
import java.util.Hashtable;

/**
 * This class implements a hash table.
 * It has an array of WordFrequency objects.
 * It implements a linear probing as a closed addressing approach to resolve collisions.
 * It should use a simple hash function,
 * as defined in hashKey that adds the character value for each letter in the String,
 * and compute modulo with the size of the table.
 */
public class HashWords {
    // private variables
    private int size;
    private WordFrequency[] words;
    private int uniqueWords = 0;

    /**
     * Constructor for the class, creates the initial array of WordFrequency objects to be of size initialSize.
     *
     * @param initialSize initial size of hash table.
     */
    public HashWords(int initialSize) {
        size = initialSize;
        words = new WordFrequency[initialSize];
    }

    /**
     * Returns the size of the table used internally.
     * When first created, this value should be equal to initialSize.
     *
     * @return size of table
     */
    public int size() {
        return words.length;
    }

    /**
     * Computes the key for argument w using the algorithm explained above and shown in Week 3's Prep Work.
     * This method is called from addWord() as part of the logic to add this word to the hash table.
     * It uses the internal size of the table to compute the index.
     *
     * @param w String word
     * @return hash value of w
     */
    public int hashKey(String w) {
        int sum = 0;
        if (w == null)
            return 0;
        for (char c : w.toCharArray()) {
            sum += (int) c;
        }
        return sum % size;
    }

    /**
     * Returns the count of WordFrequency if the word (w) exists in the table, returns 0 otherwise.
     *
     * @param w String
     * @return frequency of w
     */
    public int frequency(String w) {
        int hash = hashKey(w);
        if (contains(w)) {
            if (words[hash] != null) {
                if(words[hash].getWord().equals(w)) {
                    return words[hashKey(w)].getCount();
                } else {
                    for(int i = hash + 1; i < size; i++){
                        if(words[i] != null){
                            if(words[i].getWord().equals(w)){
                                return words[i].getCount();
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    /**
     * This method implements the algorithm to add the word to the table.
     *
     * @param w Word
     */
    public void addWord(String w) {
        while (true) {
         /*
        To add the word to the table,
        the algorithm should call hashKey() to get the index for the word.
         */
            int hash = hashKey(w);
            if (addIfContains(w)) return;
            if(addIfNotContained(w, hash)) return;
            reHash();
        }
    }


    public boolean addIfContains(String w) {
        /*
        Then, the algorithm should check to see if the word already exists in the table.
        If it is, it simply increments the count stored in the
        WordFrequency for that word and the work is done.
         */
        for (WordFrequency word : words) {
            if (word != null) {
                if (word.getWord().equals(w)) {
                    word.increment();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addIfNotContained(String w, int hash) {
        /*
        If the word is not on the table,
        the algorithm should check if there is space in the table to store one more word.
        If there is, it should proceed to add the word to the hash table.
         */
        for (int i = hash; i < size; i++) {
            if (words[i] == null) {
                words[i] = new WordFrequency(w);
                uniqueWords++;
                return true;
            }
        }
        // if we cant add it
        return false;
    }

    public void reHash() {
        /*
        If there is no more space,
        the method should grow the array and rehash all the words to add them back into the table.
        The new size needs to be 3 times of the previous size.
        Only after expanding the table and rehashing all the words,
        it should proceed to add the new word to the hash table.
         */
        size = size * 3;
        WordFrequency[] temp = words.clone();
        words = new WordFrequency[size];
        // rehash words
        for (int i = 0; i < temp.length; i++) {
            // get new hash
            if(temp[i] != null){
                int newHash = hashKey(temp[i].getWord());
                // if words at index of newHash is null, assign it to temp[i]
                if (words[newHash] == null) {
                    words[newHash] = temp[i];
                }
                // else find next empty
                else {
                    for (int x = newHash + 1; x < words.length; x++) {
                        if (words[x] == null) {
                            words[x] = temp[i];
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Does this hash table contain this word (w)? Returns true if the word is in the table, false otherwise.
     *
     * @param w Word
     * @return boolean
     */
    public boolean contains(String w) {
        for (WordFrequency wf : words) {
            if (wf != null) {
                if (wf.getWord().equals(w)) return true;
            }
        }
        return false;
    }

    /**
     * Return the number of unique words stored in the table.
     *
     * @return Int Unique words.
     */
    public int numUniqueWordsInTable() {
        return uniqueWords;
    }

    /**
     * Returns the word count of the entire document.
     *
     * @return int - Word count.
     */
    public int totalNumOfWords() {
        int sum = 0;
        for (WordFrequency wF : words) {
            if (wF != null) sum += wF.getCount();
        }
        return sum;
    }

    /**
     * This returns the word with the highest count of appearance in the table.
     *
     * @return String - most common word
     */
    public String mostCommonWord() {
        String mostCommon = "";
        int mostCommonFreq = 0;
        for (WordFrequency wF : words) {
            if (wF != null) {
                if (wF.getCount() > mostCommonFreq) {
                    mostCommon = wF.getWord();
                    mostCommonFreq = wF.getCount();
                }
            }
        }
        return mostCommon;
    }

    /**
     * Returns the term frequency of w (frequency(w) / totalNumOfWords)
     *
     * @param w Word
     * @return double - Term Frequency.
     */
    public double termFrequency(String w) {
        if (contains(w)) {
            return (double) frequency(w) / totalNumOfWords();
        } else {
            return 0;
        }
    }
}
