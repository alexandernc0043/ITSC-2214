public String linearSearch(String[] words, String search)
{
  // Iterate over all of the elements
  // searching for 'search'
  // return the element from words[] if found, null otherwise
  for(String str: words){
    if(str.equalsIgnoreCase(search)){
      return str;
    }
  }
  return null;
}
