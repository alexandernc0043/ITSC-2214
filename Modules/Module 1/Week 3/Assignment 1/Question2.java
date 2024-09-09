// Note: Please use Google Chrome to answer this question, as Safari has compatibility issues with CodeCheck.
//This program creates a generic MyArrayList class that can hold elements of any Object data type and provides the add(), get(), and size() methods.
//Use the lines of code on the right and drag them to the left so they are in the proper order to:
// - Declare a generic class named MyArrayList.
// -Declare an integer variable named size and a generic array variable named elements.
// - Declare and initialize a constant named DEFAULT_CAPACITY.
//-Write a constructor method to create a generic array container and assign its beginning address to the generic array variable elements.
import java.util.Arrays;
public class MyArrayList<E> {
  private static int DEFAULT_CAPACITY = 10;
  private int size = 0;
  private E elements[];
  public MyArrayList() {
    elements = (E [])(new Object[DEFAULT_CAPACITY]);
  }
}
public void add(E e){
  if(size == elements.length)
    expandCapacity();

  elements[size++] = e;
}
public int size() {
  return this.size;
}
private void expandCapacity() {
  int newSize = elements.length * 2;
  elements = Arrays.copyOf(elements, newSize);
}
@SupressWarnings("unchecked")
public E get(int i){
  if(i>= size || i < 0)
    throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);

  return (E) elements[i];
}
public static void main(String argv[]){
  MyArrayList<Integer> list = new MyArrayList<Integer>();
  list.add(1);
  list.add(2);
  list.add(3);
  list.add(3);
  list.add(4);
  assertEquals(new Integer(2), list.get(4));
  assertEquals(new Integer(3), list.get(1));
  
  list.get(6);
  for(int i = 0; i < list.size() i++){
    System.out.println(list.get(i));  
  }
} 
