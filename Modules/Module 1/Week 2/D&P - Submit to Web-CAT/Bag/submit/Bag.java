import itsc2214.*;
import java.util.*;

/**
 * Bag class, example for testng in ITSC 2214 Course.
 * 
 * @author manuel a. perez-quinones
 * @version July 2024
 * @param <E>
 */
public class Bag<E> extends BagADT<E> {
    private ArrayList<E> elements = new ArrayList<>();

    /**
     * Adds an element to the bag.
     * 
     * @param element adds this element to the bag
     * @return true if the addition succeeds, false otherwise
     */
    public boolean add(E element) {
        return elements.add(element);
    }

    /**
     * Removes an element from the bag.
     * 
     * @param element removes this element to the bag
     * @return true if the removal succeeds, false otherwise
     */
    @Override
    public boolean remove(E element) {
        return elements.remove(element);
    }

    /**
     * Return the size of the bag.
     * 
     * @return number of elements in the bag
     */
    public int size() {
        return elements.size();
    }

    /**
     * Returns true if 'o' is in the bag, false otherwise.
     * 
     * @param o object to see if it is in the bag
     * @return true if the object is in the elements, false otherwise.
     */
    @Override
    public boolean contains(E o) {
        return elements.contains(o);
    }

    /**
     * Clear empties the bag leaving it empty.
     */
    public void clear() {
        elements.clear();
    }

    /**
     * iterator() returns an iterator on the internal array list.
     */
    @Override
    public Iterator<E> iterator() {
        return elements.iterator();
    }
}
