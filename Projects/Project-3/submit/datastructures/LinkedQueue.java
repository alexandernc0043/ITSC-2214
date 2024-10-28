package datastructures;
import itsc2214.Node;
import itsc2214.QueueADT;

/**
 * Linked list implementation of Queues. 
 * 
 * @author ITSC 2214
 *
 * @version 1.0
 * @param <T> 
 */
public class LinkedQueue<T> implements QueueADT<T> {
    /* front: the beginning of the queue */
    private Node<T> front;
    
    /* rear: the end of the queue */
    private Node<T> rear;
    
    /* size: the number of elements in the queue */
    private int size;
    
    /**
     * Constructor.
     */
    public LinkedQueue() {
        //TODO Instantiate the linked list-based data 
        //collection
        front = new Node<T>(null,null);
        rear = new Node<T>(null,null);
        size = 0;
    }
    
    /**
     * Insert an element in the end of the queue.
     * @param target input element
     */
    @Override
    public boolean enqueue(T target) {
        /** TODO if queue is empty, insert new node
         * and change the rear and front references
         * 
         * if queue is not empty, insert new node in 
         * the rear of the queue
        **/
        Node<T> newNode = new Node<>(target, null);
        if(isEmpty()){
            front = newNode;
            rear = front;
        }
        else {
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
        return true;
    }
    
    /**
     * Remove from the beginning of the queue.
     * @return the removed element
     */
    @Override
    public T dequeue() {
        /** TODO if queue is empty, throw an exception.
        * Then remove the data item from the queue
        * Do not forget to change the size
        **/
        if(isEmpty()){
            return null;
        }
        else {
            Node<T> removedNode = front;
            front = front.getNext();
            size--;
            if(front == null){
                rear = null;
            }
            return removedNode.getData();
        }
    }
    
    /**
     * Examine whether the queue is empty.
     * @return true: if the queue is empty
     *         false: if the queue is not empty
     */
    @Override
    public boolean isEmpty() {
        //Evaluate whether the queue is empty
        return size == 0;
    }
    
    /**
     * Retrieve the front.
     * @return the element in the beginning of the queue 
     */
    @Override
    public T frontValue() {
        /**TODO return element in the frontmost position of the array **/
        if(isEmpty()){
            return null;
        } else {
            return front.getData();
        }

    }
    
    /**
     * Retrieve the size.
     * @return number of elements in the queue
     */
    @Override
    public int size() {
        //Return the size of the QueueADT
        return size;
    }

    /**
     * Clear the queue.
     */
    @Override
    public void clear() {
        while (!this.isEmpty()) {
            this.dequeue();
        }
    }
}