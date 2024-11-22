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
     * It now takes the expression to evaluate as an argument and returns the
     * expression tree (BinaryNode<String>) for the expression.
     * There is one more operator to implement in this project,
     * the "=" operator. It is also a binary operator just like the others
     * (+,*,-,/).
     * So, and expression like a 10 = is a valid expression and should be parsed
     * into the expression tree in analogous fashion as a 10 +,
     * that is the root node will contain the operator, and the left tree would have
     * a and the right 10.
     * 
     * @param expression Postfix notation.
     * @return BinaryNode<String> tree
     */
    public BinaryNode<String> parse(String expression) {
        Stack<BinaryNode<String>> stack = new Stack<>();

        if (expression == null) // if null return null.
            return null;

        for (String str : expression.split("\\s+")) { // Split the expression on spaces.
            if (str.matches("[0-9a-zA-Z]+")) { // if its a variable or number
                stack.push(new BinaryNode<String>(str)); // Push the number/variable on the stack.
            } else if (isOperator(str) && stack.size() >= 2) {
                BinaryNode<String> right = stack.pop(); // Get the right node
                BinaryNode<String> left = stack.pop(); // Get the left node.
                // push a new node on the stack
                stack.push(new BinaryNode<String>(str, left, right)); 
            } else {
                return null; // Error.
            }
        }
        return stack.pop(); // Return tree.
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

        if (tree.getValue().equals("=")) {
            int right = evaluate(tree.getRight());
            hashMap.put(tree.getLeft().getValue(), right);
            return right;
        }

        // if its a single node.
        if (tree.getLeft() == null && tree.getRight() == null) {        
            // Check if its a variable.
            if (tree.getValue().matches("[a-zA-Z]+")) {
                // return 
                return hashMap.get(tree.getValue());
            }
            else {
                // Return value.
                return Integer.parseInt(tree.getValue());
            }
        }

        int value = 0;
        int left = evaluate(tree.getLeft());
        int right = evaluate(tree.getRight());
        
        switch (tree.getValue()) {
            case "+":
                value = left + right;
                break;
            case "-":
                value = left - right;
                break;
            case "*":
                value = left * right;
                break;
            case "/":
                if (right == 0)
                    throw new ArithmeticException("Divide by zero error.");
                value = left / right;
                break;
            case "=":
                hashMap.put(tree.getLeft().getValue(), right);
                value = hashMap.get(tree.getLeft().getValue());
                break;
        }
        return value;

    }

    BinaryNode<String> simplify(BinaryNode<String> root) {
        if(root.getLeft() == null && root.getRight() == null){
            return root;
        }
        BinaryNode<String> tree = root;
        BinaryNode<String> left = tree.getLeft();
        BinaryNode<String> right = tree.getRight();
        if (root.getValue().matches("[*/]") && right.getValue().equals("1")) {
            tree = left;
        }
        if (root.getValue().matches("[+-]") && right.getValue().equals("0")) {
            tree = left;
        }
        tree.setLeft(simplify(root.getLeft()));
        tree.setRight(simplify(root.getRight()));
        return tree;
    }
}
