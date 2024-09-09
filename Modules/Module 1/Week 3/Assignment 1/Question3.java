// Note: Please use Google Chrome to answer this question, as Safari has compatibility issues with CodeCheck.
// Defining a generic class with multiple type parameters
I/ Please identify three dots and replace three dots with proper code
public class Pair<K, V> {
  private K key;
  private V value;
  public Pair(K key, V value) {
    this. key = key;
    this. value = value;
  }
  public K getKey() {
    return key;
  }
  public V getValue() {
    return value;
  }
}
public void setKey(K key) {
  this. key = key;
}
public void setValue(V value) {
  this. value = value;
}
public static void main (String[] args) {
// Creating an instance of a generic class with Integer and String types
Pair<Integer, String> intStringPair = new Pair<>(1, "One");
System.out.println ("Key: " + intStringPair.getKey() + ", Value: " + intStringPair.getValue());
// Creating an instance of a generic class with String and Double types
Pair<String, Double> stringDoublePair = new Pair<>("PI", 3.14);
System.out.println("Key: " + stringDoublePair.getKey() + ", Value: " + stringDoublePair.getValue ());
