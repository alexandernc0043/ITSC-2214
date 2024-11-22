import org.junit.*;

import itsc2214.BinaryNode;

import static org.junit.Assert.*;
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
        runner = new ExpressionTree();
    }

    /**
     * Infix notation test.
     */
    @Test
    public void testInfixNotation() {
        runner.parse("3 4 +");
    }
    /**
     * Test evaluate.
     */
    @Test
    public void testEvaluate() {
        runner.parse("3 4 +");
        assertEquals(7, runner.evaluate(runner.parse("3 4 +")));
        assertEquals(17, runner.evaluate(runner.parse("3 4 * 5 +")));
        assertEquals(23, runner.evaluate(runner.parse("3 4 5 * +")));
        assertEquals(5, runner.evaluate(runner.parse("2 3 + 4 5 * + 5 /")));
        assertEquals(5, runner.evaluate(runner.parse("10 5 -")));
        assertEquals(1, runner.evaluate(runner.parse("2 2 /")));
        assertEquals(10, runner.evaluate(runner.parse("a 10 =")));
        assertEquals(11, runner.evaluate(runner.parse("a 1 +")));
        assertEquals(11, runner.evaluate(runner.parse("a a 1 + =")));
        assertEquals(13, runner.evaluate(runner.parse("a a 1 + = 1 +")));
        assertEquals(12, runner.evaluate(runner.parse("a")));
    }
    
    /**
     * Tests that evaluate throws an exception with divide by zero.
     */
    @Test(expected = ArithmeticException.class)
    public void testEvaluateTwo() {
        runner.evaluate(runner.parse("10 0 /"));
    }
    
    /**
     * Tests simplify.
     */
    @Test
    public void testSimplify() {
        BinaryNode<String> tree = runner.simplify(runner.parse("1 0 +"));
        assertNull(tree.getLeft());
        assertNull(tree.getRight());
        assertEquals("1", tree.getValue());
        tree = runner.simplify(runner.parse("a 1 /"));
        assertNull(tree.getLeft());
        assertNull(tree.getRight());
        assertEquals("a", tree.getValue());
        tree = runner.simplify(runner.parse("a b + 1 *"));
        assertEquals("(a + b)", runner.infixNotation(tree));
        tree = runner.simplify(runner.parse("0 20 2 * +"));
        assertEquals("(20 * 2)", runner.infixNotation(tree));
        tree = runner.simplify(runner.parse("0 y 1 * +"));
        assertEquals("y", runner.infixNotation(tree));
    }
}
