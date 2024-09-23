import org.junit.*;
import static org.junit.Assert.*;

/**
 * Description
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
     * testOne() testing something
     */
    @Test
    public void testOne() {
        assertEquals("Word stored is wrong", "Hello", runner.getWord());
    }
}
