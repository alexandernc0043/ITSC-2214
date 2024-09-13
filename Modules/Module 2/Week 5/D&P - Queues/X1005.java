void moveToBack(QueueADT<String> queue)
{
    if(queue == null || queue.numElements() < 2) return;
    String value = queue.dequeue();
    queue.enqueue(value);
}

