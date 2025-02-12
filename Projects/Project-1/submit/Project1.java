import java.util.AbstractList;
import java.util.function.*;
import java.util.ArrayList;

/**
 * Project1 - class that take a collection (AbstractList) as
 * argument and provides various operations on the content of that
 * collection.
 *
 * @author Alexander Prechtel
 * @version August 30, 2024
 * @param <E>
 */
public class Project1<E extends Comparable<E>>
        implements CollectionUtilities<E> {
    private ArrayList<E> abstractList;
    
    /**
     * Constructor for Project1.
     * @param abstractList Arraylist of type E
     */
    public Project1(ArrayList<E> abstractList) {
        this.abstractList = abstractList;
    }

    /**
     * Returns the smallest item in the collection by comparing values using compareTo().
     * @return E smallest value
     */
    @Override
    public E findSmallest() {
        // If list is empty return null
        if (abstractList.isEmpty()) {
            return null;
        }
        // set smallest value to first value
        E smallestValue = abstractList.get(0);
        for (E e : abstractList) {
            /* 
            if current value (e) is smaller then smallestValue, 
            set smallestValue to current value (e)
            */
            if(e.compareTo(smallestValue) < 0){
                smallestValue = e;
            }
        }
        return smallestValue;
    }

    /**
     * Returns the largest item in the collection by comparing values using compareTo().
     * @return E largest value
     */
    @Override
    public E findLargest() {
        // If empty return null
        if (abstractList.isEmpty()) {
            return null;
        }
        // set largestValue to first value
        E largestValue = abstractList.get(0);
        for (E i : abstractList) {
            // if current value (i) is larger set largestValue to current value (i)
            if (i.compareTo(largestValue) > 0) {
                largestValue = i;
            }
        }
        return largestValue;
    }

    /**
     * Returns true if the collection contains a value more then once, otherwise returns false.
     * @return boolean
     */
    @Override
    public boolean hasDuplicates() {
        // make arraylist to store seen values
        ArrayList<E> seenValues = new ArrayList<>();
        for (E i : abstractList) {
            if (seenValues.contains(i)) { // If it contains the value return true
                return true;
            } else { // Otherwise add it to the list
                seenValues.add(i);
            }
        }
        return false; // If no duplicates return false
    }
    
    /**
     * returns the first element found that when passed to p.test(), 
        the test returns true. You don't know what p.test() does, 
        as that predicate is passed in as an argument to this method. 
        @return E
        @param p Predicate
     */
    public E findOneThat(Predicate<E> p) {
        for (E e : abstractList) {
            // if it passes return current value (e)
            if (p.test(e)) {
                return e;
            }
        }
        return null; // if nothing passes the test return null
    }

    /**
     * return a new collection holding only those elements 
     * that evaluate to true when passed to the p.test() predicate.
     * Your code needs to return a new object of type AbstractList<E>.
     * One common subtype of this class is ArrayList<E>.
     * You could create an ArrayList<E>, 
     * iterate over the collection and those elements that make p.test()
     * return true add them to the new collection. At the end, return this new collection.
     * This routine should always return a collection, even if it is empty.
     * @param p Predicate
     * @return AbstractList<E>
     */
    public AbstractList<E> filterList(Predicate<E> p) {
        // list to return
        ArrayList<E> returnList = new ArrayList<E>();
        for (E e : abstractList) {
            // if it passes the test add it to the list
            if(p.test(e)){
                returnList.add(e);
            }
        }
        return returnList;
    }
}
