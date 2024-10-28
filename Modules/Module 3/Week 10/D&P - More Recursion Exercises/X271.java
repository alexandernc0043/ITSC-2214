public int recursiveMin(int numbers[], int startIndex) {
  if (startIndex == numbers.length - 1) {
    return numbers[startIndex];
  } else {
    return Math.min(numbers[startIndex], recursiveMin(numbers, startIndex + 1));
  }
}
