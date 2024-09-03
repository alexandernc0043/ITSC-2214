String longest(String[] names)
{
    if(names.length == 0) return null; 
   String longest = names[0];
    for(String s : names){
    if(s.length() > longest.length()) longest = s;
    }
    return longest;
}

