public class Name {
  // ...
  public Name (String f, String l) { ... }
  public String getFirst() { ... }
  public String getLast() { ... }
  @Override
  public String toString() { return getLast()+", "+getFirst(); }
}
public class Name {
  // ...
  public Name (String f, String l) { ... }
  public String getFirst() { ... }
  public String getLast() { ... }
  @Override
  public String toString() { return getLast()+", "+getFirst(); }
}
public int compare(Name o1, Name o2)
{
  if(o1 == null && o2 == null) return 0;
    else if(o1 == null) return -1;
    else if(o2 == null) return 1;
    int lastCompare = o1.getLast().compareTo(o2.getLast());
    if(lastCompare < 0) return -1;
    else if(lastCompare > 0) return 1;
    else {
      int firstCompare = o1.getFirst().compareTo(o2.getFirst());
      if(firstCompare < 0) return -1;
      else if(firstCompare == 0) return 0;
      else return 1;
    }
}
