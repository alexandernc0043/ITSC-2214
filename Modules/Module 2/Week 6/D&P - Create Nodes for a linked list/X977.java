public class node<E> {
  //... instance variables
  public node(E d, node<E> n) {
    this.data = d;
    this.next = n;
  }
  public E getData() {return data; }
  public void setData(E d) {data = d; }
  public node<E> getNext() {return next; }
  public void setNext(node<E> n) {next = n; }
}

public node<E> buildNodes(E[] values)
{
  node<E> node = new node<E>(values[0], null);
  node<E> head = node;
  for(int i = 1; i < values.length; i++){
      node<E> newNode = new node<E>(values[i], null);
      head.setNext(newNode);
      head = newNode;
  }
    return node;
}

