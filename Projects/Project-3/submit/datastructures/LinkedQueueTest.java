package datastructures;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

/**
 * ITSC 2214 Melody
 * Instructor-provided code.
 */
public class LinkedQueueTest {
    LinkedQueue<Integer> queue;

    /**
     * Initialize the LinkedQueue instance.
     */
    @Before
    public void setup() {
        queue = new LinkedQueue<Integer>();
    }

    /**
     * Test of enqueue method, of class LinkedQueue.
     */
    @Test
    public void testEnqueue() {
        //TODO test your enqueue method of LinkedQueue<Integer>
        queue.enqueue(4);
        assertEquals(queue.frontValue(), Integer.valueOf(4));
        queue.enqueue(5);
        assertEquals(queue.frontValue(), Integer.valueOf(4));
        queue.clear();
        assertNull(queue.frontValue());

    }

    /**
     * Test of isEmpty method, of class LinkedQueue.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(6);
        assertFalse(queue.isEmpty());
    }
    
    /**
     * Test of dequeue method, of class LinkedQueue.
     */
    @Test
    public void testDequeue() {
        //TODO test your dequeue method of LinkedQueue<Integer>
        assertTrue(queue.isEmpty());
        assertNull(queue.dequeue());
        queue.enqueue(1);
        assertEquals(1, queue.size());
        int value = queue.dequeue();
        assertEquals(1, value);
        assertTrue(queue.isEmpty());

    }

    /**
     * Test of first method, of class LinkedQueue.
     */
    @Test
    public void testFrontValue1() {
        assertEquals(0, queue.size());
        assertNull(queue.frontValue());
    }
        
    /**
     * Test of first method, of class LinkedQueue.
     */
    @Test
    public void testFrontValue2() {
        queue.enqueue(4);
        assertEquals(queue.frontValue().intValue(), 4);
        queue.enqueue(6);
        assertEquals(queue.frontValue().intValue(), 4);
        queue.dequeue();
        assertEquals(queue.frontValue().intValue(), 6);
    }

    /**
     * Test of size method, of class LinkedQueue.
     */
    @Test
    public void testSize() {
        queue.enqueue(4);
        assertEquals(queue.size(), 1);
        queue.dequeue();
        assertEquals(queue.size(), 0);
    }

    /**
     * Test of clear() method, of class LinkedQueue.
     */
    @Test
    public void testClear() {
        queue.enqueue(4);
        queue.enqueue(4);
        queue.clear();
        assertEquals(0, queue.size());
        assertNull(queue.frontValue());
    }
}
