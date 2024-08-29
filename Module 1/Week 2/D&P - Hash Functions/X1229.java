public int hashSumDigits(int value, int size)
{
  
  char[] numbers = String.valueOf(value).toCharArray();
  int sum = 0;
  for(char i : numbers){
    sum += Integer.parseInt(String.valueOf(i));
  }
  return sum % size;
}

