public boolean contains(int[] numbers, int search)
{
  // Iterate over all of the elements
  for (int num : numbers)
  {
    // if the number is at the current location
    if (num == search) { // then you found it
      return true;
    }
  }

  // We made it here, thus we didn't find it.
  return false;
}