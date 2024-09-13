QueueADT<String> copyStackToQueue(StackADT<String> stack)
{
    QueueArray<String> val = new QueueArray<String>();
    if(stack == null) return val;
    while(!stack.isEmpty()){
    	String temp = stack.pop();
        val.enqueue(temp);
    }
    return val;
}

