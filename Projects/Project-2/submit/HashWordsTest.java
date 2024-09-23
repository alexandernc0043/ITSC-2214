import org.junit.*;
import static org.junit.Assert.*;

/**
 * Description
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
     * testOne() testing something
     */
    @Test
    public void testOne() {
        assertEquals("Size of table is wrong",
                10, runner.size());
    }
}
