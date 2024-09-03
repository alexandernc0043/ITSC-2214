public int countStrLongerThan(ArrayList<String> names, int minLen)
{
    int count = 0;
  if(names == null) return 0;
    for(String s : names){
   if(s.length() > minLen) count++;
    }
    return count;
}

