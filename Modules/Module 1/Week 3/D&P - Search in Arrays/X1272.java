public int linearSearch(int[] numbers, int search)
{
  // Iterate over all of the elements
  // searching for value
  // return index if found, -1 otherwise
  for(int i = 0; i < numbers.length; i++){
    if(numbers[i] == search){
      return i;
    }
  }
  return -1;
}
