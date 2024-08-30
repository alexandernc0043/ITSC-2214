// Note: Please use Google Chrome to answer this question, as Safari has compatibility issues with CodeCheck.

// Complete the code by replacing the three dots with the appropriate expression or statement in the ArrayListApp constructor. 
// This constructor should initialize the courseList ArrayList by iterating through the provided courses array and adding each element to courseList.


import java.util.ArrayList;
import java.util.Iterator;

class Course{
    String dept;
    int number;
    public Course(String dept, int number){
        this.dept = dept;
        this.number = number;
    } 
    public String getDept() { return this.dept; }
    public int getNumber() { return this.number; }
    public void setDept(String dept) { this.dept = dept; }
    public void setNumber(int number) { this.number = number; }
}


public class ArrayListApp {
    ArrayList<Course> courseList = new ArrayList<Course>();

    // Constructor that aims to initialize the ArrayList instance, named courseList 
    // with the input array of courses through an indexed for loop that iteratively 
    //adds the reference of each element from the array to the ArrayList.
    public ArrayListApp(Course courses[]){ 
       for (int i = 0; i < courses.length; i++)
          courseList.add(courses[i]);
       }

    public int size() { return this.courseList.size(); }

    public static void main(String[] args) throws Exception {
        Course introCourses[] = { new Course("ITSC",1212), 
                                   new Course("ITSC",1213), 
                                   new Course("ITSC",2175), 
                                   new Course("ITSC", 2214)};
        ArrayListApp introCourseList = new ArrayListApp(introCourses);
        System.out.println(introCourseList.size());
    }
}
