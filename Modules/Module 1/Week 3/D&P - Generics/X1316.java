public int binarySearch(int[] numbers, int search)
{
   int low = 0;
   int high = numbers.length - 1;

   while (low <= high) {
      int mid = (low + high)/2;
      if (search == numbers[mid])
         return mid;  // found it
      else if (search < numbers[mid])
         high = mid - 1;
      else
         low = mid + 1;
   }
   return -1;  // not found
}
public class QuizQuestion<E extends Comparable<E>>
{
   public int binarySearch(E[] items, E search)
   {
      int low = 0;
      int high = numbers.length - 1;
      while(low <= high){
         int mid = (low + high)/2;
         if(search.compareTo(numbers[mid]) == 0)
            return mid;
         else if(search.compareTo(numbers[mid]) < 0)
            high = mid - 1;
         else
            low = mid + 1;
      }
      return -1;
   }
}