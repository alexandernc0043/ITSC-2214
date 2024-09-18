public int linearSearch(String[] words, String search)
{
  // Iterate over all of the elements
  // searching for 'search'
  // return the index into words[] if found, -1 otherwise
  for(int i = 0; i < words.length; i++){
    if(words[i].equalsIgnoreCase(search)){
      return i;
    }
  }
  return -1;
}
