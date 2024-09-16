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

public node<E> build2Nodes(E a, E b)
{
  return new node<E>(a,new node<E>(b,null));
}

