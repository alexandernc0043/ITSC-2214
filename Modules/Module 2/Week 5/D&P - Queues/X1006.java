void moveNToBack(QueueADT<String> queue, int n)
{
    if(queue == null || queue.numElements() < n) return;
    for(int i = 0; i < n; i++){
        String value = queue.dequeue();
        queue.enqueue(value);
    }
}

