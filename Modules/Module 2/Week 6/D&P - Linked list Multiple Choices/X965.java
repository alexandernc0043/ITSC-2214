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

curr = head;
curr = curr.getNext();
curr.setNext(new node<String>("E", curr.getNext()));

answer = head -> ["A"]-> ["B"]-> ["E"]-> ["C"]-> ["D"]