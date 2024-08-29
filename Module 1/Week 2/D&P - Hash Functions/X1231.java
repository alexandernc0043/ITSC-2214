int sascii(String value, int size) 
{
  char ch[] = value.toCharArray();
  int sum = 0;
  for (int i = 0; i < value.length(); i++) {
    sum += (int) ch[i];
  }
  return sum % size;
}

