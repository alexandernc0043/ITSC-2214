public class Name implements Comparable<Name> {
  private String first;
  private String last;
  public Name (String f, String l) { ... }
  public String getFirst() { ... }
  public String getLast() { ... }
  public String toString() { return getLast()+", "+getFirst(); }
  public int compareTo(Name other) {
    // to be completed
  }
}

public int compareTo(Name other){
  if(other == null) return -1;
  else if(this.getLast().compareTo(other.getLast()) < 0) return -1;
  else if(this.getLast().compareTo(other.getLast()) == 0) return 0;
  else return 1;
}