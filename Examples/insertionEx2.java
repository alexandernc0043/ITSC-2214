/*
 * insertion sort = after comparing elements to the left shift elements to the right to make room to insert a value
 * Quadratic time O(n^2)
 * small data set = decent
 * large data set = bad
 * less steps than bubble sort
 * best case is O(n) compared to Selection Sort O(n^2)
 */


private static void insertionSort(int[] array){
  for(int i = 1; i < array.length; i++){
    int temp = array[i];
    int j = i - 1;
      
    while(j >= 0 && array[j] > temp){
      array[j+1] = array[j]; // moves array to the right
      j--;
    }
    array[j+1] = temp;
  }
}

private static String printArray(int[] array) {
  String ret = "";
  for (int i : array) {
    ret += (i + ", ");
  }
  return ret;
}
public static void main(String[] args){
  int array[] = {9,1,8,2,7,3,5,4};
  System.out.println("Orginal Array: " + printArray(array));
  insertionSort(array);
  System.out.println("Sorted Array: " + printArray(array));

}
