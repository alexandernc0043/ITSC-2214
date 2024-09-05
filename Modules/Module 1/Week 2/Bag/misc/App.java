import itsc2214.*;

/**
 * App class, example for ITSC 2214 Course.
 * 
 * @author manuel a. perez-quinones
 * @version July 2024
 */
public class App
{
    public static void main(String[] args) throws Exception 
    {
        BagADT<String> b = new Bag<>();
        b.add("Hello");
        b.add("World");

        for (String s : b) {
            System.out.println(" item: "+s);
        }
    }
}
