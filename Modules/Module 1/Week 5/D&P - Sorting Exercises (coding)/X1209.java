/*
public void insertionSort(T[] values) {

   for (int i = 1; i < values.length; i++) {
      for (int j = i; j > 0; j--) {
         if (compare values at j and j-1) {
            // Swap values when appropriate
            
         }
      }
   }
}
*/

public void insertionSort(T[] values) {

   for (int i = 1; i < values.length; i++) {
      for (int j = i; j > 0; j--) {
         if (values[j].compareTo(values[j-1]) < 0) {
            // Swap values when appropriate
            T temp = values[j];
            values[j] = values[j-1];
            values[j-1] = temp;
         }
      }
   }
}
