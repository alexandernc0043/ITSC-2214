//Use some lines of code on the right and drag them to the left so they are in the proper order to make the addStudent() method complete.


import java.util.ArrayList;

public class CourseManagementByArrayList {
    ArrayList<Pair<Integer, Integer>> course_enrollments;

    public CourseManagementByArrayList() {
        this.course_enrollments = new ArrayList<>();
    }

    public void addStudent(Integer course_code) {
        if (course_code == null) return;
    /* Procedure:
    Iteratively search the ArrayList for the entry corresponding to the given course code.
    If the course code is found, increase the associated number of enrollments by one.
    If the course code is not found, add a new entry with the course code and an initial enrollment count of one.
    */
        int i = 0;
        for (Pair<Integer, Integer> pair : this.course_enrollments) {
            if (pair != null && course_code.equals(pair.getKey())) {
                this.course_enrollments.get(i).setValue(this.course_enrollments.get(i).getValue() + 1);
            }
            i++;
        }
    }

    public void dropStudent(Integer course_code) {
        if (course_code == null) return;
        int i = 0;
        for (Pair<Integer, Integer> pair : this.course_enrollments) {
            if (pair != null && course_code == pair.getKey().intValue()) {
                int value = this.course_enrollments.get(i).getValue();
                if (value > 0)
                    this.course_enrollments.get(i).setValue(value - 1);
                else
                    this.course_enrollments.remove(i);
                return;
            }
            i++;
        }
    }

    // add a pair, allowing duplicated pairs
    public void add(Integer course_code, int enrollments) {
        if (course_code == null) return;
        int i = 0;
        for (Pair<Integer, Integer> pair : course_enrollments) {
            if (pair != null && course_code == pair.getKey().intValue()) {
                pair.setValue(enrollments);
                return;
            }
        }
        this.course_enrollments.add(new Pair(course_code, enrollments));
    }

    public void add(Integer course_code) {
        this.course_enrollments.add(new Pair(course_code, 0));
    }
    public void addCourseIfAbsent(Integer course_code, int enrollments){
        if (course_code == null) return;
        for(Pair<Integer, Integer> pair: this.course_enrollments){
            if(pair != null && course_code == pair.getKey().intValue())
                return;
        }
        this.course_enrollments.add(new Pair(course_code, enrollments));
    }
    public void remove(Integer course_code, int enrollments){
        this.course_enrollments.remove(new Pair(course_code, enrollments));
    }
    public void remove(Integer course_code){
        if(course_code == null) return;
        for(Pair<Integer, Integer> pair: this.course_enrollments){
            if(pair != null && course_code == pair.getKey().intValue()){
                this.course_enrollments.remove(pair);
                        return;
            }
        }
    }
    public void print(){
        System.out.println("{");
        for(Pair<Integer,Integer> pair: this.course_enrollments)
            System.out.println(pair.getKey() + ": " + pair.getValue() + ": " + pair.getKey().hashCode());
        System.out.println("}");
    }

    public static void main(String[] args) {
        CourseManagementByArrayList man = new CourseManagementByArrayList();
        man.add(2214);
        man.add(1212,69);
        man.remove(1212,69);
        man.add(1212,69);
        man.remove(1212);
        man.addStudent(2214);
        man.dropStudent(2214);
        man.addCourseIfAbsent(1213,56);
        man.addCourseIfAbsent(1213,78);
        man.add(1213,78);
        man.print();
    }
}
class Pair<K, V>{
    private K key;
    private V value;
    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }
    public K getKey(){
        return key;
    }
    public V getValue(){
        return value;
    }
    public void setKey(K key){
        this.key = key;
    }
    public void setValue(V value){
        this.value = value;
    }
}
