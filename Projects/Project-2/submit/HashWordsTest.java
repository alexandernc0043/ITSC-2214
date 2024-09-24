import org.junit.*;
import static org.junit.Assert.*;

/**
 * Class to test HashWords class.
 */
public class HashWordsTest {
    // Object to be tested
    private HashWords runner;

    /**
     * setup() method, runs before each test method below.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    @Before
    public void setup() {
        runner = new HashWords(10);
        runner.addWord("hello");
    }

    /**
     * Tests size of Hashtable
     * Expected 10.
     */
    @Test
    public void testOne() {
        assertEquals(10, runner.size());
    }
    /**
     * Tests hashkey function.
     * Expected 2
     */
    @Test
    public void testTwo(){
        assertEquals(2, runner.hashKey("hello"));
    }
    /**
     * Tests frequency getter.
     * Expected 1
     */
    @Test
    public void testThree(){
        assertEquals(1, runner.frequency("hello"));
        assertEquals(2, runner.hashKey("hello"));
        assertEquals(0, runner.frequency("world"));
    }
    /**
     * Tests the contain method.
     */
    @Test
    public void testFour(){
        assertTrue(runner.contains("hello"));
        assertFalse(runner.contains("world"));
    }
    /**
     * Tests the addWord() method.
     */
    @Test
    public void testFive(){
        assertEquals(1, runner.totalNumOfWords());
        runner.addWord("world");
        assertEquals(2, runner.totalNumOfWords());
    }
    /**
     * Tests the uniqueWords getter.
     */
    @Test
    public void testSix(){
        assertEquals(1, runner.numUniqueWordsInTable());
        runner.addWord("world");
        assertEquals(2, runner.numUniqueWordsInTable());
        runner.addWord("world");
        assertEquals(2, runner.numUniqueWordsInTable());
    }
}
