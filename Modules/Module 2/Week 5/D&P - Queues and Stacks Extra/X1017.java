StackADT<String> copyQueueToStack(QueueADT<String> queue)
{
    StackArray<String> returnVal = new StackArray<String>();
    if(queue == null) return returnVal;
    while(!queue.isEmpty()){
        String val = queue.dequeue();
    	returnVal.push(val);
    }
    return returnVal;
}

