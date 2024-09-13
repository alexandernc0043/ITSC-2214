void removeFirstN(QueueADT<String> queue, int n)
{
    if(queue == null) return;
    if(queue.numElements() > n){
        for(int i = 0; i < n; i++){
            queue.dequeue();
        }
    } else {
        while(queue.numElements() != 0){
            queue.dequeue();
        }
    }
}

