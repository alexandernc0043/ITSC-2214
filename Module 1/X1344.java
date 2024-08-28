int findItem(Course[] courses, Course lookFor)
{
  for(int i = 0; i< courses.length; i++){
      if(courses[i].compareTo(lookFor) == 0){
          return i;
      }
  }
    return -1;
  
}

