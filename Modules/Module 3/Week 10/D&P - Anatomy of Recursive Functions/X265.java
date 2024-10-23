/*
The greatest common divisor (GCD) for a pair of numbers is the largest positive integer that divides both numbers without remainder. 
For function GCD, write the missing base case condition and action. 
This function will compute the greatest common divisor of x and y. 
You can assume that x and y are both positive integers and that x > y. 

Greatest common divisor is computed as follows: GCD(x, 0) = x and GCD(x, y) = GCD(y, x % y).
*/
public int GCD(int x, int y) {
  if (y == 0) {
	return x;
  } else {
    return GCD(y, x % y);
  }
}
