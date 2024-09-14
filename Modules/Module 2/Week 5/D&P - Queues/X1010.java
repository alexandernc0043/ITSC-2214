void keepEvens(QueueADT<Integer> queue)
{
    if(queue == null) return;
    QueueADT<String> evens = new QueueADT<String>();
    for(int i = 0; i < queue.numElements(); i++) {
        Integer value = queue.dequeue();
        if(value % 2 == 0){
            evens.enqueue(value);
        }
    }
    queue = evens;
}

