public boolean add(E element)
{
   // 1. Add an element to the set.
   if(!set.contains(element)){
   	set.add(element);
       return true;
   } else {
       return false;
   }
   // 2. Return true if the object was added correctly
    
}
