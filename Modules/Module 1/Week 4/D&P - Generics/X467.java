public class Answer<T>
{
  private T value;

  public void setValue(T newValue){
    value = newValue;
  }
  public T getValue(){
    return value;
  }
}
