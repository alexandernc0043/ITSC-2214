void removeFirstTwo(QueueADT<String> queue)
{
    if(queue == null || queue.numElements() < 2) return;
    queue.dequeue();
    queue.dequeue();
}

