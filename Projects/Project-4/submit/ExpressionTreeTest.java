import org.junit.*;
import static org.junit.Assert.*;
import itsc2214.*; // not needed now, but you might in your projects

/**
 * Class to test ExpressionTree.
 */
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
     * Parse Test.
     */
    @Test
    public void testParse() {
        assertTrue(runner.parse());
        runner = new ExpressionTree(null);
        assertFalse(runner.parse());
        runner = new ExpressionTree("+ + +");
        assertFalse(runner.parse());

    }
    /**
     * getRoot Test.
     */
    @Test
    public void testGetRoot() {
        assertNull(runner.getRoot());
        runner.parse();
        assertNotNull(runner.getRoot());
        assertEquals("+", runner.getRoot().getValue());
    }
    /**
     * Infix notation test.
     */
    @Test
    public void testInfixNotation() {
        assertEquals("(3 + 4)", runner.infixNotation());

        runner = new ExpressionTree("3 4 * 5 +");
        assertEquals("((3 * 4) + 5)", runner.infixNotation());

        runner = new ExpressionTree("3 4 5 * +");
        assertEquals("(3 + (4 * 5))", runner.infixNotation());

        runner = new ExpressionTree("10");
        assertEquals("10", runner.infixNotation());

        runner = new ExpressionTree("2 3 + 4 5 * + 5 /");
        assertEquals("(((2 + 3) + (4 * 5)) / 5)", runner.infixNotation());

        runner = new ExpressionTree("9 5 - 2 +");
        assertEquals("((9 - 5) + 2)", runner.infixNotation());
    }
    /**
     * Test evaluate.
     */
    @Test
    public void testEvaluate() {
        assertEquals(7, runner.evaluate());

        runner = new ExpressionTree("3 4 * 5 +");
        assertEquals(17, runner.evaluate());

        runner = new ExpressionTree("3 4 5 * +");
        assertEquals(23, runner.evaluate());

        runner = new ExpressionTree("10");
        assertEquals(10, runner.evaluate());

        runner = new ExpressionTree("2 3 + 4 5 * + 5 /");
        assertEquals(5, runner.evaluate());
    }
    
    /**
     * Tests that evaluate throws an exception with divide by zero.
     */
    @Test(expected = ArithmeticException.class)
    public void testEvaluateTwo() {
        runner = new ExpressionTree("0 0 /");
        runner.evaluate();
    }
}
