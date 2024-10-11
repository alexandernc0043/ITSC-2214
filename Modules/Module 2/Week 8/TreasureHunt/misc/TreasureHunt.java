import java.util.function.Predicate;

/**
 * Double Linked List Treasure Hunt Assignment.
 *
 * @author Alexander Prechtel
 * @version Sep 25, 2024
 */
class LocationNode implements Comparable<LocationNode> {
    String name;
    boolean hasTreasure;
    private LocationNode next;
    private LocationNode prev;

    LocationNode(String name, boolean hasTreasure) {
        this.name = name;
        this.hasTreasure = hasTreasure;
    }

    public String getName() {
        return this.name;
    }

    public boolean hasTreasure() {
        return this.hasTreasure;
    }

    @Override
    public String toString() {
        if (this.hasTreasure)
            return this.name + "[Y]";
        else
            return this.name + "[N]";
    }

    @Override
    public boolean equals(Object arg0) {
        return this.name.equalsIgnoreCase(((LocationNode) arg0).getName())
                && this.hasTreasure == ((LocationNode) arg0).hasTreasure;
    }

    @Override
    public int compareTo(LocationNode arg0) {
        return this.name.compareToIgnoreCase(arg0.getName());
    }

    /**
     * Gets the node that follows this one
     * 
     * @return next linear node
     */
    public LocationNode getNext() {
        return next;
    }

    /**
     * Sets the node that follows this one
     * 
     * @param n LinearNode to follow this one
     */
    public void setNext(LocationNode n) {
        next = n;
    }

    /**
     * Gets the node that is before this one
     * 
     * @return prev LinearNode<T>
     */
    public LocationNode getPrev() {
        return prev;
    }

    /**
     * Sets the node that is before this one
     * 
     * @param p LinearNode to put before this one
     */
    public void setPrev(LocationNode p) {
        prev = p;
    }
}

public class TreasureHunt {

    private LocationNode first;
    private LocationNode last;
    private int numNodes;

    public TreasureHunt() {
        first = null;
        last = null;
        numNodes = 0;
    }

    public void addLast(String location, boolean hasTreasure) {
        LocationNode temp = new LocationNode(location, hasTreasure);
        if (numNodes == 0) {
            first = temp;
            last = temp;
            numNodes++;
            return;
        }
        temp.setPrev(last);
        last.setNext(temp);
        last = temp;
        numNodes++;
    }

    /**
     * Traverse the list starting from the head (starting point of the
     * treasure hunt) and print out the name of each location and whether
     * it contains a treasure. After reaching the last location (the tail),
     * traverse backward through the list to return to the starting point.
     * Print in the following example format. For example,
     * Location [Y]->Riverbank [Y]->Abandoned Hut [N]->Riverbank [Y]->Forest [Y].
     * TODO Write statement for the following two cases:
     * - Do nothing, when the treasure map (doubly linked list) is empty
     * - When the treasure map is not empty
     * - Walk from the first location node through the second last node by using the
     * ndex reference variable of each node
     * - Walk from the last node through the first node by using the
     * prev reference variable of each node
     */
    public void traverse() {
        // Do nothing, when the treasure map (doubly linked list) is empty
        if (this.first == null)
            return;
        if (this.last == null)
            return;
        // The treasure map is not empty
        // Walk from the first location node through the second last node
        // by using the next reference variable of each node
        LocationNode cur = this.first;
        while (cur.getNext() != null) {
            System.out.print(cur + "->");
            cur = cur.getNext();
        }

        // TODO Traverse from the last node through the
        // first node by using the prev reference variable
        // of each node and print. Refer to the previous while loop
        LocationNode last = this.last;
        while (last != null) {
            System.out.print(last.toString());
            if(last.getPrev() != null){
                System.out.print("<-");
            }
            last = last.getPrev();
        }
        System.out.println();
    }

    /**
     * Insert a new location (node) in between two existing locations,
     * before and after.
     * 
     * @param newLocation    New location name
     * @param newHasTreasure Whether this new location has treasure
     * @param before         The existing location after which the new location will
     *                       be inserted
     * @param after          The existing location before which the new location
     *                       will
     *                       be inserted
     */
    public void insert(String newLocation, boolean newHasTreasure, String before, String after) {
        // Do nothing when the treasure map has less than two locations or is null
        if (this.first == null || this.first == this.last) {
            return;
        }

        // TODO When the treasure map has two or more than two locations
        // a) Walk through the treasure map and location the before and after locations
        // b) Make a new location node and insert the new node between two existing
        // locations
        LocationNode current = first;
        while (current != null && current.getNext() != null) {
            if (current.getName().equals(before) && current.getNext().getName().equals(after)) {
                LocationNode newNode = new LocationNode(newLocation, newHasTreasure);
                LocationNode afterNode = current.getNext();
                current.setNext(newNode);
                newNode.setNext(afterNode);
                newNode.setPrev(current);
                afterNode.setPrev(newNode);
                return;
            } else {
                current = current.getNext();
            }
        }
    }

    /**
     * Remove that nodes of having no treasures from the treasure
     * map (doubly linked list).
     * 
     * @param p Creteria that judge whether a location node satisfies
     */
    public void remove(Predicate<LocationNode> p) {
        if (this.first == null)
            return;

        LocationNode cur = this.first;
        LocationNode pre = this.first;
        while (cur != null) {
            if (p.test(cur)) {
                // True branch: locate the locationNode satifying the condition
                // TODO Remove the identified node with the following three cases into
                // consideration

                // 1) If the identified node is the first node of the map,
                // we need to remove this node and change the first reference variable
                // to reflect the change after removing
                
                // 2) If the identified node is the last node of the map,
                // we need to remove this node and change
                // the last reference variable to reflect the change after removing
                
                // 3) If the identified node is the node somewhere in the middle of the map,
                // we need to remove this node and hook up its previous node and its next node
                if(cur == first){
                    cur = cur.getNext();
                    cur.setPrev(null);
                    return;
                }
                if(cur == last){
                    cur = cur.getPrev();
                    cur.setNext(null);
                }
                else{
                    cur.getPrev().setNext(cur.getNext());
                    cur.getNext().setPrev(cur.getPrev());
                }
                return;

            } else {
                cur = cur.getNext();
                pre = cur.getPrev();
            }
        }
    }

    public static void main(String[] argv) {
        TreasureHunt map = new TreasureHunt();
        map.addLast("Forest", true);
        map.addLast("Riverbank", true);
        map.addLast("Abandoned Hut", false);
        map.addLast("Desert  of Wonders", true);

        map.traverse();
        map.insert("Cave  of Wonders", true, "Forest", "Riverbank");

        System.out.println("After insertion, ");
        map.traverse();

        Predicate<LocationNode> hasNoTreasure = i -> i.hasTreasure() == false;
        map.remove(hasNoTreasure);

        System.out.println("After removing, ");
        map.traverse();
    }
}