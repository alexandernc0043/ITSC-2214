import itsc2214.*; // not needed now, but you might in your projects

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
     * @param w - String
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
        // if it contains w
        if(contains(w)){
            // and the word at the hashkey is w
            if(words[hashKey(w)].getWord().equals(w)){
                // increment the word
                words[hashKey(w)].increment();
            }
            else {
                // find the word using linear probing
                for(int i = hashKey(w) + 1; i < words.length; i++){
                    // if word at index i is w
                    if(words[i].getWord().equals(w)){
                        // increment word at index i
                        words[i].increment();
                    }
                }
            }
        }
        else {
            // if the space is empty
            if(words[hashKey(w)] == null){
                // assign word at haskey(w)
                words[hashKey(w)] = new WordFrequency(w);
            }
            else {
                for(int i = hashKey(w) + 1; i < words.length; i++){
                    if()
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
     * You should keep track of this number internally, rather than compute it when requested.
     * Each time you add a word to the table, add 1 to an internal counter if it is a new word (unique).
     * Then return the value of that counter when this method is called.
     * Note that this is a count of the number of unique words stored in the table.
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
     * There is a concept called term frequency,
     * and it refers to a measure that indicates how unique a term (or word)
     * is in the particular collection of words represented by this table.
     * It is computed as a ratio of the number of times a particular word appears divided by the total number of words in the document.
     * This method returns the result of  frequency(w) / totalNumOfWords().
     * If the word w is not on the table, this method returns 0.
     * @param w Word
     * @return double
     */
    public double termFrequency(String w) {
        // TODO change this
        return 0.0;
    }
}
