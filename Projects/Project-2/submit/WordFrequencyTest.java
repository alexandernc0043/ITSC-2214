import org.junit.*;
import static org.junit.Assert.*;

/**
 * Class to test Word Frequency.
 */
public class WordFrequencyTest {
    // Object to be tested
    private WordFrequency runner;

    /**
     * setup() method, runs before each test method below.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    @Before
    public void setup() {
        runner = new WordFrequency("Hello");
    }

    /**
     * Tests word getter.
     * Expected "Hello"
     */
    @Test
    public void testOne() {
        assertEquals("Hello", runner.getWord());
    }

    /**
     * Tests count getter.
     * Expected 1
     */
    @Test
    public void testTwo() {
        assertEquals(1, runner.getCount());
    }

    /**
     * Tests increment.
     * Expected 1 -> 2
     */
    @Test
    public void testThree() {
        assertEquals(1, runner.getCount());
        runner.increment();
        assertEquals(2, runner.getCount());
    }

    /**
     * Tests equal.
     */
    @Test
    public void testFour() {
        WordFrequency runner2 = new WordFrequency("Hello");
        assertEquals(runner2, runner);
        assertTrue(runner2.equals("Hello"));
        assertEquals(runner2, runner2);
        assertFalse(runner2.equals("World"));
        assertFalse(runner2.equals(1));
    }
}
