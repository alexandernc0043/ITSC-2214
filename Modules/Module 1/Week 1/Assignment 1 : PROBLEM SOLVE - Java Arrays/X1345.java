Course findSmallest(Course[] courses)
{
  // put your loop here
    Course smallest = courses[0];
  for(Course course : courses)
  {
      if(course.compareTo(smallest) < 0)
      {
          smallest = course;
      }
  }
    return smallest;
}

