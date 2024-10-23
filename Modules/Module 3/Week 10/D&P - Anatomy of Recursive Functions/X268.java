/* 
For function addOdd(n) write the missing recursive call. 
This function should return the sum of all postive odd numbers less than or equal to n.
*/
public int addOdd(int n) {
  if (n <= 0) {
    return 0;
  }
  if (n % 2 != 0) { // Odd value
    return n + addOdd(n - 1);
  } else { // Even value
    return addOdd(n - 1);
  }
}
