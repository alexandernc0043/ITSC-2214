import itsc2214.*;
public class ArrayStack<E> implements StackADT<E> {
 // 1. Define instance variable here, name it stack
   private ArrayList<E> stack;
//
// Constructor
public ArrayStack()
{
   // 2. Create new instance
   stack = new ArrayList<E>();
}
public void clear()
{
   // 3. Empty the internal list that holds the values
   // for the stack by simply creating a new one.
      stack = new ArrayList<E>();

}

}