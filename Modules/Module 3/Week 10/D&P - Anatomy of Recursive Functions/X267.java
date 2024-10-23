/*
For function sumtok, write the missing recursive call. This function returns the sum of the values from 1 to k.
*/
public int sumtok(int k) {
  if (k <= 0) {
    return 0;
  } else {
    return k + sumtok(k-1);
  }
}
