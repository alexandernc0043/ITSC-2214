import itsc2214.*;
public class ArraySet<E> implements SetADT<E> {
 // code for the problems goes here
   // 1. Define instance variable here, name it set
   private ArrayList<E> set;
//
// Constructor
public ArraySet()
{
   // 2. Create new instance
    set = new ArrayList<E>();
}
public void clear()
{
   // 3. Empty the internal list that holds the values
   // for the set by simply creating a new one.
   set = new ArrayList<E>();
}
}

