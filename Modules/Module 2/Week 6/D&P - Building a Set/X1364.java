public boolean remove(E element)
{
   // 1. remove an element to the set.
   if(set.contains(element)){
       set.remove(element);
       return true;
   } else {
       return false;
   }
   // 2. Return true if the object was removed.
    
}
