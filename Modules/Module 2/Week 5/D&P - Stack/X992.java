/*
public interface StackADT<E> { // Stack class ADT
  * Clears the stack. *
  public void clear();

  * Pushes argument it onto the stack. *
  public boolean push(E it);

  * Pop and return the value at the top of the stack. *
  public E pop();

  * Returns the value at the top of the stack. *
  public E topValue();

  * Returns the number of elements stored in the stack. *
  public int numElements();

  * Returns true if the stack is empty, false otherwise. *
  public boolean isEmpty();
}
*/
void swapTopTwo(StackADT<String> stack)
{
    if(stack.numElements() < 2) return;
    String temp = stack.pop();
    String temp2 = stack.pop();
    stack.push(temp);
    stack.push(temp2);
}

