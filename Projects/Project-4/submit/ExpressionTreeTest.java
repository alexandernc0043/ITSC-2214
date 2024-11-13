import org.junit.*;
import static org.junit.Assert.*;
import itsc2214.*; // not needed now, but you might in your projects

public class ExpressionTreeTest {

    /**
     * runner - known as the "test runner" object, this is the
     * object that you will use in testing. You will use this
     * object in each of your tests after reinitializing (new)
     * in the setup() method below.
     */
    private ExpressionTree runner;

    /**
     * setup() method, runs before each test method below.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    @Before
    public void setup() {
        runner = new ExpressionTree("3 4 +");
    }

    /**
     * Parse Test
     */
    @Test
    public void testParse() {
        assertTrue(runner.parse());

    }
    /**
     * getRoot Test
     */
    @Test
    public void testGetRoot() {
        assertNull(runner.getRoot());
        runner.parse();
        assertNotNull(runner.getRoot());
        assertEquals("+", runner.getRoot());
    }
}
