public class Name {
  // ...
  public Name (String f, String l) { ... }
  public String getFirst() { ... }
  public String getLast() { ... }
  @Override
  public String toString() { return getLast()+", "+getFirst(); }
}
public class CompareLastName implements Comparator<Name>
{
  public int compare(Name o1, Name o2) {
    // your code goes here
  }
}
public int compare(Name o1, Name o2)
{
    if(o1 == null && o2 == null) return 0;
    else if(o1 == null) return -1;
    else if(o2 == null) return 1;
    int lastCompare = o1.getLast().compareTo(o2.getLast());
    if(lastCompare < 0) return -1;
    else if(lastCompare > 0) return 1;
    else return 0;
}
