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
    private WordFrequency[] hashTable;
    private int uniqueWords = 0;

    /**
     * Constructor for the class,
     * creates the initial array of WordFrequency objects to be of size initialSize.
     *
     * @param initialSize initial size of hash table.
     */
    public HashWords(int initialSize) {
        size = initialSize;
        hashTable = new WordFrequency[initialSize];
    }

    /**
     * Returns the size of the table used internally.
     * When first created, this value should be equal to initialSize.
     *
     * @return size of table
     */
    public int size() {
        return hashTable.length;
    }

    /**
     * Computes the key for argument w using the algorithm
     * It uses the internal size of the table to compute the index.
     *
     * @param w String word
     * @return hash value of w
     */
    public int hashKey(String w) {
        int sum = 0;
        for (char c : w.toCharArray()) {
            sum += c;
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
        // if w is null return 0.
        if (w == null) {
            return 0;
        }
        // compute the hash.
        int hash = hashKey(w);
        // if the table at index of hash is not null and the word is w return the count.
        if (hashTable[hash] != null && hashTable[hash].getWord().equals(w)) {
            return hashTable[hash].getCount();
        }
        // find the word w in the table.
        for (int i = hash + 1; i < size; i++) {
            if (hashTable[i] != null && hashTable[i].getWord().equals(w)) {
                return hashTable[i].getCount();
            }
        }
        // Table doesnt contain w so return 0.
        return 0;
    }

    /**
     * This method implements the algorithm to add the word to the table.
     *
     * @param w Word
     */
    public void addWord(String w) {
        // if w is null return.
        if (w == null) {
            return;
        }
        while (true) {
            // compute hash
            int hash = hashKey(w);
            // if we contain it find it and increment it.
            if (contains(w)) {
                if (hashTable[hash].getWord().equals(w)) {
                    hashTable[hash].increment();
                    return;
                }
                for (int i = hash + 1; i < size; i++) {
                    if (hashTable[i] == null) continue;

                    if (hashTable[i].getWord().equals(w)) {
                        hashTable[i].increment();
                        return;
                    }
                }
            }
            // if we dont contain it find an empty space for it.
            if (hashTable[hash] == null) {
                hashTable[hash] = new WordFrequency(w);
                uniqueWords++;
                return;
            }
            for (int i = hash + 1; i < size; i++) {
                if (hashTable[i] == null) {
                    hashTable[i] = new WordFrequency(w);
                    uniqueWords++;
                    return;
                }
            }
            // if no space rehash the table and expand size by 3.
            reHashTable();
        }
    }

    /**
     * This method rehashes the table and is used in the addWord Method.
     */
    public void reHashTable() {
        size = size * 3;
        WordFrequency[] tableClone = hashTable.clone();
        hashTable = new WordFrequency[size];
        uniqueWords = 0;
        for (WordFrequency wordFrequency : tableClone) {
            if (wordFrequency == null) continue;
            addWord(wordFrequency.getWord());
        }
    }

    /**
     * Does this hash table contain this word (w)?
     * Returns true if the word is in the table, false otherwise.
     *
     * @param w Word
     * @return boolean
     */
    public boolean contains(String w) {
        // if w is null return false.
        if (w == null) {
            return false;
        }
        // Compute the hash.
        int hash = hashKey(w);
        // if at index of hash is null return as we won't have it.
        if (hashTable[hash] == null) {
            return false;
        }
        // If at index of hash is the word return true.
        if (hashTable[hash].getWord().equals(w)) {
            return true;
        }
        // Find the word if not
        for (int i = hash + 1; i < hashTable.length; i++) {
            if (hashTable[i] != null && hashTable[i].getWord().equals(w)) {
                return true;
            }
        }
        // Return false as we don't contain it.
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
        for (WordFrequency wF : hashTable) {
            if (wF == null) continue;
            sum += wF.getCount();
        }
        return sum;
    }

    /**
     * This returns the word with the highest count of appearance in the table.
     *
     * @return String - most common word
     */
    public String mostCommonWord() {
        // two variables to store the frequency of the word and the word.
        String mostCommon = "";
        int mostCommonFreq = 0;
        for (WordFrequency wF : hashTable) {
            if (wF != null) {
                // if the count is higher reassign variables to new word and count.
                if (wF.getCount() > mostCommonFreq) {
                    mostCommon = wF.getWord();
                    mostCommonFreq = wF.getCount();
                }
            }
        }
        // return it.
        return mostCommon;
    }

    /**
     * Returns the term frequency of w (frequency(w) / totalNumOfWords).
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
