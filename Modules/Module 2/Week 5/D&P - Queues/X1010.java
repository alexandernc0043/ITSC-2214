void keepEvens(QueueADT<Integer> queue)
{
    if(queue == null) return;
    int size = queue.numElements();
    for(int i = 0; i < size; i++) {
        Integer value = queue.dequeue();
        if(value % 2 == 0){
            queue.enqueue(value);
        }
    }
}
