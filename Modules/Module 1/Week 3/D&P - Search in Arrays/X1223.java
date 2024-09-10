public int binarySearch(int[] numbers, int search)
{
  int low = 0; // low range
  int high = numbers.length -1; // high range 
  int mid; //mid range

  while (low <= high)  // while low is less than or equal to high
  {
    mid = (low + high)/2; // set the middle index

    // if the number at mid is what we are looking for
    if (numbers[mid] == search) { // found it
      return mid;
    }
    // else if the number at mid ...
    else if (numbers[mid] > search) { 
        // change the range to 1/2 of the array
      high = mid -1;
    }
    else
    {
        // change the range to the OTHER 1/2 of the array
      low = mid + 1;
    }     
  }

  // We are done, thus we didn't find it.
  return -1;
}
