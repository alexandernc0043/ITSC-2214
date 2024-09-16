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
public static node<String> changeMe(node<String> head)
{
    node<String> node = head;
    node<String> temp = head.getNext(); // (b , c)
    node<String> tempTwo = temp.getNext(); // (c , d)
    node.setNext(temp.getNext()); // sets a,c,d
    temp.setNext(tempTwo.getNext()); // sets (b,d)
    tempTwo.setNext(temp); // c, b, d
    node.setNext(tempTwo); // a , c , b , d
    return node;
}
