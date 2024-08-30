import java.util.AbstractList;
import java.util.Collection;
import java.util.function.*;
import java.util.ArrayList;

/**
 * Project1 - class that take a collection (AbstractList) as
 * argument and provides various operations on the content of that
 * collection.
 *
 * @author Alexander Prechtel
 * @version August 30, 2024
 */
public class Project1<E extends Comparable<E>>
        implements CollectionUtilities<E> {
    private ArrayList<E> abstractList;

    public Project1(ArrayList<E> abstractList) {
        this.abstractList = abstractList;
    }

    /**
     * Returns the smallest item in the collection by comparing values using compareTo()
     * @return E smallest value
     */
    @Override
    public E findSmallest() {
        //Variable to Return
        E smallestValue = abstractList.getFirst(); // set to first value

        //Loop through the list
        for (E i : abstractList) {
            if (i.compareTo(smallestValue) < 0) { // smaller than 0 set smallestValue to i
                smallestValue = i;
            }
        }
        return smallestValue; // Return Variable
    }

    /**
     * Returns the largest item in the collection by comparing values using compareTo()
     * @return E largest value
     */
    @Override
    public E findLargest() {
        //Variable to Return
        E largestValue = abstractList.getFirst(); // Set to first value

        //Loop through the list
        for (E i : abstractList) {
            if (i.compareTo(largestValue) > 0) { // if larger than 0 set smallestValue to i
                largestValue = i;
            }
        }
        return largestValue; // Return the largest variable
    }

    /**
     * Returns true if the collection contains a value more then once, otherwise returns false
     * @return boolean
     */
    @Override
    public boolean hasDuplicates() {
        // List of values we've seen already, starts empty
        ArrayList<E> seenValues = new ArrayList<>();
        // Loop through the list
        for (E i: abstractList){
            if(seenValues.contains(i)){ // If it contains the value return true
                return true;
            } else { // Otherwise add it to the list
                seenValues.add(i);
            }
        }
        return false; // If no duplicates return false
    }
}
