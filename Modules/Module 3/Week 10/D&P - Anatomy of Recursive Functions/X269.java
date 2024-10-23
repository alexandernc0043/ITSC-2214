/*
For function sumOfDigits, write the missing recursive call. 
This function takes a non-negative integer and returns the sum of its digits.
*/
public int sumOfDigits(int number) {
  if (number < 10)
    return number;
  return number % 10 + sumOfDigits(number / 10);
}
