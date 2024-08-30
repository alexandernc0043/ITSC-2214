import java.util.AbstractList;
import java.util.ArrayList;

/**
Short main program to demo how to use Project1.java

@author  mapq
@version Aug 06, 2024
*/
public class Project1Main {
    public static void main(String[] args) throws Exception 
    {
        example1();
        example2();
    }

    /**
     * example 1 of how to use the Project1 with
     * strings.
     */
    public static void example1()
    {
        // Example 1 - Project1 with strings
        ArrayList<String> words = new ArrayList<>();
        words.add("A");
        words.add("BB");
        words.add("CCCC");
        words.add("ABCDE");
        for (String v : words) {
            System.out.println(v);
        }
        Project1<String> collection = new Project1<String>(words);
        System.out.println("Smallest = "+collection.findSmallest());
        System.out.println("Largest = "+collection.findLargest());
    }

    /**
     * example 2 - how to use Project1 with Integers
     */
    public static void example2()
    {
        // Example 2: Project1 with numbers
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(15);
        for (Integer v : numbers) {
            System.out.println(v);
        }
        Project1<Integer> numCollection = new Project1<Integer>(numbers);
        System.out.println("Smallest = "+numCollection.findSmallest());
        System.out.println("Largest = "+numCollection.findLargest());

    }
}
