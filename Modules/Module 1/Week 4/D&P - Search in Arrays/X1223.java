public int binarySearch(int[] numbers, int search)
{
  int low = 0; // low range
  int high = numbers.length -1; // high range 
  int mid; //mid range

  while (__)  // while low is less than or equal to high
  {
    mid = __; // set the middle index

    // if the number at mid is what we are looking for
    if (__) { // found it
      return mid;
    }
    // else if the number at mid ...
    else if (__) { 
        // change the range to 1/2 of the array
        __
    }
    else
    {
        // change the range to the OTHER 1/2 of the array
        __
    }     
  }

  // We are done, thus we didn't find it.
  return -1;
}
