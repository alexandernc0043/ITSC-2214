void removeFirst2Add3(QueueADT<String> queue)
{
    if(queue == null || queue.numElements() < 2) return;
    queue.dequeue();
    queue.dequeue();
    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");
}

