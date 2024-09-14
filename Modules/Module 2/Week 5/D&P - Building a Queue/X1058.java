public boolean enqueue(E it)
{
  // 1. Add an element to the list on rear.
  try{
    list.add(it);
      return true;
  } catch(Exception e){
      return false;
  }
      // 2. Return true if the object was added correctly
  
}

