public class QueueExample {
    public static void main(String[] args) {

    }
}

class Queue<E> {
    private E[] queue;
    private int front;
    private int rear;
    private int size;

    public Queue(int size) {
        queue = (E[]) new Object[size];
        front = rear - 1;
    }

    public boolean enqueue(E element) {
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % queue.length;
        }
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public int size() {
        return size;
    }
}