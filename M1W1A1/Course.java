/*
 * Complete Course.compareTo()
 */

/*
 * If [other] is null, return a negative value (< 0).
 * If the department in this object is less than the department in [other], return a negative value (< 0).
 * If the department in this object is equal to the department in [other], then compare the course number.
 * Return a negative value if this number is less than the course number of the [other]
 * Return 0 if the numbers are equal.
 * Return a positive number if this number is greater than the course number of other
 * Otherwise return a positive number (> 0).
 */
public class Course implements Comparable<Course>
{
    private String dept;
    private int number;
    public Course (String d, int n) {
        dept = d;
        number = n;
    }
    public String getDept() { return dept; }
    public int getNum() { return number; }
    public String toString() {
        return getDept()+getNum();
    }

    public int compareTo(Course other)
    {
        if(other == null)
        {
            return -1; // Return a negative number if null
        }
        if (this.getDept() == other.getDept())
        {
            return 0; // If equal return 0
        }
        else if (this.getDept().compareTo(other.getDept())<0)
        {
            return -1; // Return a negative number if
        }
        else
        {
            if(this.getNum() < other.getNum())
            {
                return -1; // Return negative number if less than other
            }
            else if (this.getNum() > other.getNum())
            {
                return 1; // Return positive if greater
            }
            else if(this.getNum() == this.getNum())
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }
    }
}