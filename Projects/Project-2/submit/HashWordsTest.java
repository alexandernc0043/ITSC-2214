import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class to test HashWords class.
 */
public class HashWordsTest {
    // Object to be tested
    private HashWords runner;
    private HashWords testRunner;

    /**
     * setup() method, runs before each test method below.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    @Before
    public void setup() {
        runner = new HashWords(10);
        runner.addWord("hello");
        testRunner = new HashWords(3);
        // 2 hello
        testRunner.addWord("hello");
        testRunner.addWord("hello");
        // 3 world
        testRunner.addWord("world");
        testRunner.addWord("world");
        testRunner.addWord("world");
        // 4 bye
        testRunner.addWord("bye");
        testRunner.addWord("bye");
        testRunner.addWord("bye");
        testRunner.addWord("bye");
        // size 3
    }

    /**
     * Tests size of Hashtable
     * Expected 10.
     */
    @Test
    public void testSize() {
        assertEquals(10, runner.size());
        assertEquals(3, testRunner.size());
    }

    /**
     * Tests hashkey function.
     * Expected 2
     */
    @Test
    public void testHashKey() {
        assertEquals(2, runner.hashKey("hello"));
        testRunner = new HashWords(10);
        assertEquals(0, testRunner.hashKey("bye"));
    }

    /**
     * Tests frequency getter.
     * Expected 1
     */
    @Test
    public void testFrequency() {
        assertEquals(1, runner.frequency("hello"));
        assertEquals(2, runner.hashKey("hello"));
        assertEquals(0, runner.frequency("world"));
        assertEquals(2, testRunner.frequency("hello"));
        assertEquals(3, testRunner.frequency("world"));
        assertEquals(4, testRunner.frequency("bye"));
        assertEquals(0, runner.frequency(null));
    }

    /**
     * Tests the contain method.
     */
    @Test
    public void testContains() {
        assertTrue(runner.contains("hello"));
        assertFalse(runner.contains("world"));
    }

    /**
     * Tests the addWord() method.
     */
    @Test
    public void testTotalNumWords() {
        assertEquals(1, runner.totalNumOfWords());
        runner.addWord("world");
        assertEquals(2, runner.totalNumOfWords());
        assertEquals(9, testRunner.totalNumOfWords());
    }

    /**
     * Tests the uniqueWords getter.
     */
    @Test
    public void testUniqueWords() {
        assertEquals(1, runner.numUniqueWordsInTable());
        runner.addWord("world");
        assertEquals(2, runner.numUniqueWordsInTable());
        runner.addWord("world");
        assertEquals(2, runner.numUniqueWordsInTable());
        assertEquals(3, testRunner.numUniqueWordsInTable());
    }

    /**
     * Tests the mostCommonWord method.
     */
    @Test
    public void testMostCommonWord() {
        assertEquals("hello", runner.mostCommonWord());
        runner.addWord("world");
        runner.addWord("world");
        assertEquals("world", runner.mostCommonWord());
        assertEquals("bye", testRunner.mostCommonWord());
    }

    /**
     * Tests the termFrequency method.
     */
    @Test
    public void testTermFreq() {
        assertEquals((double) 2 / 9, testRunner.termFrequency("hello"), 0.0);
        assertEquals((double) 3 / 9, testRunner.termFrequency("world"), 0.0);
        assertEquals((double) 4 / 9, testRunner.termFrequency("bye"), 0.0);
        assertEquals(0.0, testRunner.termFrequency("a"), 0.0);
    }

    /**
     * Tests addWords() method.
     */
    @Test
    public void testAddWords() {
        runner = new HashWords(3);
        runner.addWord("a");
        runner.addWord("b");
        runner.addWord("c");
        runner.addWord("d");
        runner.addWord("e");
        runner.addWord("f");
        assertEquals(9, runner.size());
        assertEquals(6, runner.numUniqueWordsInTable());
        assertEquals(6, runner.totalNumOfWords());
        runner = new HashWords(2);
        runner.addWord("dog");
        runner.addWord("god");
        runner.addWord("dgo");
        assertEquals(1, runner.frequency("dog"));
        assertEquals(1, runner.frequency("god"));
        assertEquals(1, runner.frequency("dgo"));

    }
}
