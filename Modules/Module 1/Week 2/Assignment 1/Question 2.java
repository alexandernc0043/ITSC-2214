// Use some lines of code on the right and drag them to the left so they are so they are in the proper order to make the addStudent() method complete

import java.util.HashMap;
import java.util.Map.Entry;

public class CourseManagementByHashMap {
    HashMap<Integer, Integer> course_enrollments;

    public CourseManagementByHashMap() {
        this.course_enrollments = new HashMap<>();
    }

    public void addStudent(Integer course_code) {
        if (course_code == null) return;
        if (this.course_enrollments.containsKey(course_code))
            this.course_enrollments.put(course_code,
                    this.course_enrollments.get(course_code) + 1);
        else
            this.course_enrollments.put(course_code, 1);
    }

    public void dropStudent(Integer course_code) {
        if (course_code == null) return;

        if (this.course_enrollments.containsKey(course_code)) {
            int value = this.course_enrollments.get(course_code);
            if (value > 0)
                this.course_enrollments.put(course_code, value - 1);
            else
                this.course_enrollments.remove(course_code);
        }
    }

    // add a pair, allowing duplicated pairs
    public void add(Integer course_code, int enrollments) {
        this.course_enrollments.put(course_code, enrollments);
    }

    public void add(Integer course_code) {
        this.course_enrollments.put(course_code, 0);
    }

    public void addCourseIfAbsent(Integer course_code, int enrollments) {
        if (course_code == null) return;
        this.course_enrollments.putIfAbsent(course_code, enrollments);
    }

    public void remove(Integer course_code, int enrollments) {
        this.course_enrollments.remove(course_code, enrollments);
    }

    public void remove(Integer course_code) {
        if (course_code == null) return;
        this.course_enrollments.remove(course_code);
    }

    public void print() {
        System.out.println("{");
        for (Entry<Integer, Integer> pair : this.course_enrollments.entrySet())
            System.out.println(pair.getKey() + ": " + pair.getValue() + ": " + pair.hashCode());
        System.out.println("}");
    }

    public static void main(String[] args) {
        CourseManagementByHashMap man = new CourseManagementByHashMap();
        man.add(2214, 76);
        man.add(1212, 69);
        man.remove(1212, 69);
        man.remove(1212);
        man.addStudent(2214);
        man.dropStudent(2214);
        man.addCourseIfAbsent(1213, 56);
        man.addCourseIfAbsent(1213, 78);
        man.add(1213, 78);
        man.print();
    }

}
