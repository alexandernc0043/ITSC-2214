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
     * @param initialSize initial size of hash table.
     */
    public HashWords(int initialSize) {
        size = initialSize;
        words = new WordFrequency[initialSize];
    }

    /**
     * Returns the size of the table used internally.
     * When first created, this value should be equal to initialSize.
     * @return size of table
     */
    public int size() {
        return words.length;
    }

    /**
     * Computes the key for argument w using the algorithm explained above and shown in Week 3's Prep Work.
     * This method is called from addWord() as part of the logic to add this word to the hash table.
     * It uses the internal size of the table to compute the index.
     * @param w String word
     * @return hash value of w
     */
    public int hashKey(String w) {
        int sum = 0;
        for(char c : w.toCharArray()){
            sum += (int) c;
        }
        return sum % size;
    }

    /**
     * Returns the count of WordFrequency if the word (w) exists in the table, returns 0 otherwise.
     * @param w String
     * @return frequency of w
     */
    public int frequency(String w) {
        if(contains(w)) return frequency(w);
        return 0;
    }

    /**
     * This method implements the algorithm to add the word to the table.
     * @param w Word
     */
    public void addWord(String w) {
        // hash value of w
        int hash = hashKey(w);
        // if words at the index of the hash of w is w, increment words at index hash
        if (words[hash] == null){
            words[hash] = new WordFrequency(w);
            uniqueWords++; // increment unique words

        }
        // if the word is not in the table add it
        else if(words[hash].getWord().equals(w)){
            words[hash].increment();

        }
        else {
            for(int i = hash + 1; i < size; i++){
                if(words[i] == null) {
                    words[i] = new WordFrequency(w);
                    uniqueWords++; // increment unique words
                    break;
                }
            }
            // if that doesn't work expand words by 3
            words = Arrays.copyOf(words, size * 3);
            size = size * 3;
            // retry finding a spot
            for(int i = hash + 1; i < size; i++){
                if(words[i] == null) {
                    words[i] = new WordFrequency(w);
                    uniqueWords++; // increment unique words
                }
            }
        }
    }

    /**
     * Does this hash table contain this word (w)? Returns true if the word is in the table, false otherwise.
     * @param w Word
     * @return boolean
     */
    public boolean contains(String w) {
        for(WordFrequency wF : words)
            if(wF.getWord().equals(w)) return true;
        return false;
    }

    /**
     * Return the number of unique words stored in the table.
     * @return Int Unique words.
     */
    public int numUniqueWordsInTable() {
        return uniqueWords;
    }

    /**
     * Returns the word count of the entire document.
     * @return int - Word count.
     */
    public int totalNumOfWords() {
        int sum = 0;
        for(WordFrequency wF : words){
            sum += wF.getCount();
        }
        return sum;
    }

    /**
     * This returns the word with the highest count of appearance in the table.
     * @return String - most common word
     */
    public String mostCommonWord() {
        String mostCommon = "";
        int mostCommonFreq = 0;
        for(WordFrequency wF : words){
            if(wF.getCount() > mostCommonFreq){
                mostCommon = wF.getWord();
                mostCommonFreq = wF.getCount();
            }
        }
        return mostCommon;
    }

    /**
     * Returns the term frequency of w (frequency(w) / totalNumOfWords)
     * @param w Word
     * @return double - Term Frequency.
     */
    public double termFrequency(String w) {
        if(contains(w)){
            return (double) frequency(w) / totalNumOfWords();
        } else {
            return 0;
        }
    }
}
