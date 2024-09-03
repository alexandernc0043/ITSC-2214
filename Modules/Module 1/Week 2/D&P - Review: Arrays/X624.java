public int countStrLongerThan(String[] names, int minLen)
{
  int count = 0;
    for(String s : names){
  if(s.length() > minLen) count++;
  }
    return count;
}

