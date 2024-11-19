import itsc2214.*;

import java.util.HashMap;
import java.util.Stack;

/**
 * ExpressionTree takes a string in postfix notation as an argument to the
 * constructor.
 * This class will store this expression and have methods that process the
 * expression.
 * The expression is readonly, can't be changed and the object of type
 * ExpressionTree will represent that particular expression that is passed as
 * argument to the constructor.
 *
 * @author Alexander Prechtel
 * @version Nov 13, 2024
 */
public class ExpressionTree {
    private HashMap<String, Integer> hashMap;
    /**
     * Constructor.
     */
    public ExpressionTree() {
        hashMap = new HashMap<>();
    }

    /**
     * The parse routine is similar as before but the method signature changed. 
     * It now takes the expression to evaluate as an argument and returns the expression tree (BinaryNode<String>) for the expression. 
     * There is one more operator to implement in this project, 
     * the "=" operator. It is also a binary operator just like the others (+,*,-,/). 
     * So, and expression like a 10 = is a valid expression and should be parsed into the expression tree in analogous fashion as a 10 +, 
     * that is the root node will contain the operator, and the left tree would have a and the right 10. 
     * 
     * @return BinaryNode<String> tree
     */
    public BinaryNode<String> parse() {
        
    }


    /**
     * Determines if the string is a operator.
     * 
     * @param str Thing to evaluate
     * @return boolean is a operator
     */
    private boolean isOperator(String str) {
        return str.matches("[*/+=-]");
    }
    /**
     * Method evaluates the tree stored internally and returns an integer
     * representing the value of the expression.
     * The expression should support addition (+), multiplication (*),
     * subtraction (-) and division (/).
     * 
     * @throws ArithmeticException (Divide by 0)
     * @param tree BinaryNode<String>
     * @return int evaluated the equation.
     */
    public int evaluate(BinaryNode<String> tree) throws ArithmeticException {
        
    }
}
