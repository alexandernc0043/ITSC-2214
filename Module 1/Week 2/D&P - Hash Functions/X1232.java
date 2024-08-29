public int hashAverage(String value, int size)
{
 int sum = 0;
 char[] chars = value.toCharArray();
 for(char c : chars) {
  sum += charPosition(c);
 }
 return (sum / chars.length) % size;
}
