boolean contains(Course[] courses, Course lookFor)
{
  for(Course c : courses){
      if(c.compareTo(lookFor) == 0){
          return true;
      }
  }
    return false;
  
}
