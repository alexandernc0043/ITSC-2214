void reverseQueue(QueueADT<String> queue)
{
    if(queue == null) return;
    StackArray<String> temp = new StackArray<String>();
    while(!queue.isEmpty()){
    	temp.push(queue.dequeue());
    }
    while(!temp.isEmpty()){
    	queue.enqueue(temp.pop());
    }
    
}

