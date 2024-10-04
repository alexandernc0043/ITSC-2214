import itsc2214.*;
/**
 * WordFrequency class to be used in a hash table.
 *
 * @author Alexander Prechtel
 */
public class WordFrequency {
    // declare private variables here
    private final String word;
    private int count = 1;

    /**
     * Constructor for WordFrequency.
     *
     * @param w Word.
     */
    public WordFrequency(String w) {
        word = w;
    }

    /**
     * Returns word.
     *
     * @return String - Word.
     */
    public String getWord() {
        return word;
    }

    /**
     * Returns the word frequency count.
     *
     * @return int - Count.
     */
    public int getCount() {
        return count;
    }

    /**
     * Increments count by one.
     */
    public void increment() {
        count++;
    }

    /**
     * equals() - compares two WordFrequency objects
     * checking to see if they are the same. Equality
     * is defined by string matching ignoring case.
     * 
     * @param other object to compare against
     * @return true if this and other are equals, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other instanceof String) {
            String w = (String) other;
            return getWord().equalsIgnoreCase(w);
        } else if (other instanceof WordFrequency) {
            WordFrequency wf = (WordFrequency) other;
            String w = wf.getWord();
            return getWord().equalsIgnoreCase(w);
        } else {
            return false;
        }
    }
}
