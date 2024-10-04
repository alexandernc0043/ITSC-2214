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
     * explained above and shown in Week 3's Prep Work.
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
        int hash = hashKey(w);
        int frequency = 0;
        if (w == null) {
            return 0;
        } else if (!contains(w)) {
            return 0;
        } else if (hashTable[hash] != null && hashTable[hash].getWord().equals(w)) {
            return hashTable[hash].getCount();
        } else {
            for (int i = hash + 1; i < size; i++) {
                if (hashTable[i] != null && hashTable[i].getWord().equals(w)) {
                    frequency = hashTable[i].getCount();
                    break;
                }
            }
        }
        return frequency;
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
            /*
        Then, the algorithm should check to see if the word already exists in the table.
        If it is, it simply increments the count stored in the
        WordFrequency for that word and the work is done.
         */
            if (contains(w)) {
                if (hashTable[hash] != null && hashTable[hash].getWord().equals(w)) {
                    hashTable[hash].increment();
                    return;
                } else {
                    for (int i = hash + 1; i < size; i++) {
                        if (hashTable[i] != null && hashTable[i].getWord().equals(w)) {
                            hashTable[i].increment();
                            return;
                        }
                    }
                }
            }
            if (hashTable[hash] == null) {
                hashTable[hash] = new WordFrequency(w);
                uniqueWords++;
                return;
            } else {
                for (int i = hash + 1; i < size; i++) {
                    if (hashTable[i] == null) {
                        hashTable[i] = new WordFrequency(w);
                        uniqueWords++;
                        return;
                    }
                }
            }
            // if we cant add it
            size = size * 3;
            WordFrequency[] temp = hashTable.clone();
            hashTable = new WordFrequency[size];
            // rehash words
            for (int i = 0; i < temp.length; i++) {
                // get new hash
                if (temp[i] != null) {
                    int newHash = hashKey(temp[i].getWord());
                    // if words at index of newHash is null, assign it to temp[i]
                    if (hashTable[newHash] == null) {
                        hashTable[newHash] = temp[i];
                    }
                    // else find next empty
                    else {
                        for (int x = newHash + 1; x < hashTable.length; x++) {
                            if (hashTable[x] == null) {
                                hashTable[x] = temp[i];
                                break;
                            }
                        }
                    }
                }
            }
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
        int hash = hashKey(w);
        if (hashTable[hash] != null && hashTable[hash].getWord().equals(w)) return true;
        for (int i = hash + 1; i < hashTable.length; i++) {
            if (hashTable[i] != null && hashTable[i].getWord().equals(w)) return true;
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
        for (WordFrequency wF : hashTable) {
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
        for (WordFrequency wF : hashTable) {
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
