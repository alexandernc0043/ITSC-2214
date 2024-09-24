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
     * Tests
     */
}
