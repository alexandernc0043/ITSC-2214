// Note: Please use Google Chrome to answer this question, as Safari has compatibility issues with CodeCheck.
//Use some lines of code on the right and drag them to the left so they
//are in the proper order to construct a public static generic method, named copyArray ( ) .
//The generic copyArray() method declares and initializes a new array, based on the given array of any Object type.
//It copies all elements one by one in the order of their indexes in the given array to the new array, and then return the new array.
public class TestGenericMethod {
  public static <T> TIl copyArray(T[] inputs) {
    T[] newarray = (T []) (new Object[inputs.length]);
    for (int i = 0; i<inputs.length; i++)
      newarray [i] = inputs[i];
  return newarray;
  }
}
/**
* @param args the command line arguments
*/
public static void main (Stringll args) {
  Integer [] intArry = {1,2, 3, 4, 5 };
  Double [] doubArry = {1.1, 2.2, 3.3, 4.4};
  Character [] charArray = {'H','E','L','L','O'};
  String [] strArray = {"once", "upon", "a", "time"};
  copyArray (intArry);
  copyArray (doubArry);
  copyArray (charArray);
  copyArray (strArray);
}
