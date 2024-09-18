public int linearSearch(int[] numbers, int search)
{
  /*
   Iterate over all of the elements searching.
   if found, return the index.
   if the value being search is less than the
    current value in the array, then stop and
    return the current index.
   If you reach the end of the array return -1.
   */
  for(int i = 0; i < numbers.length; i++){
    if(numbers[i] > search){
      return i;
    }
    else if(numbers[i] == search){
      return i;
    }
  }
  return -1;
}
