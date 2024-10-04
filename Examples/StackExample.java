import java.util.EmptyStackException;

public class StackExample {
    public static void main(String[] args) {
        Stack myStack = new Stack(10);
        System.out.println(myStack.isEmpty());
    }
}
class Stack<E> {
    int top;
    E[] stack;

    /**
     * Default Constructor of size 5
     */
    public Stack() {
        stack = (E[]) new Object[5]; // Default Capacity is 5
        top = -1;
    }

    /**
     * Constructor
     *
     * @param size size of stack.
     */
    public Stack(int size) {
        stack = (E[]) new Object[size];
        top = -1;
    }

    /**
     * Returns if the stack is empty or not.
     *
     * @return if empty
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Returns the size of the stack.
     *
     * @return size
     */
    public int size() {
        return top + 1;
    }

    /**
     * Adds an element to the stack.
     *
     * @param element
     */
    public void pop(E element) {
        if (top + 1 == stack.length) throw StackOverFlowException;
        else if (isEmpty()) {
            stack[++top] = element;
        } else {
            stack[++top] = element;
        }
    }
    
    /**
     * Big O(n) complexity worst case.
     * @param element
     */
    public void push(E element) {
        if (top + 1 == stack.length) {
            E[] newStack = (E[]) new Object[stack.length * 2];
            for (int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
        top++;
        stack[top] = element;
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            E result = stack[top];
            stack[top] = null;
            top--;
            return result;
        }
    }
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            return stack[top];
        }
    }
}

