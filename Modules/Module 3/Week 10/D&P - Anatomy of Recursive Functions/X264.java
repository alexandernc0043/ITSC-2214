/*
For function multiply, write the missing base case condition and action. 
This function will multiply two numbers x and y. 
You can assume that both x and y are positive.
*/
public int multiply(int x, int y) {
  if (x==0) {
return 0;
  } else {
    return multiply(x - 1, y) + y;
  }
}
