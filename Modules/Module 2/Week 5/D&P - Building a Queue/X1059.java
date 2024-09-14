public E dequeue()
{
  // 1. Remove the first element in the queue.
  E value = list.get(0);
  list.remove(0);
  // 2. Return said element
  return value;
}

