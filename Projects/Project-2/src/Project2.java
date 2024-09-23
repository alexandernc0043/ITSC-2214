import java.util.*;
import itsc2214.*;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors

/**
 * Driver for Project 2 for the Fall 2024 of the ITSC 2214 Course.
 * 
 * @author manuel a. perez-quinones
 * @version July 2024
 */
public class Project2 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a hashmap from string to integers
        HashWords table = new HashWords(17);

        // Read from a file
        File theFile = new File("preamble.txt");
        Scanner scanner = new Scanner(theFile).useDelimiter("[\\s\\p{Punct}]+");
        while (scanner.hasNext()) {
            String w = scanner.next();
            table.addWord(w);
        }

        // Print the results
        System.out.println("Size of the table " + table.size());
        System.out.println("Number of unique words " + table.numUniqueWordsInTable());
        System.out.println("Total number of words " + table.totalNumOfWords());
        String common = table.mostCommonWord();
        System.out.println("Most common word " + common);
        System.out.println("Frequency of \"" + common + "\": " + table.frequency(common));
        System.out.println("Term frequency of \"" + common + "\": " + table.termFrequency(common));

        // Test one word
        System.out.println("Contains? \"United\": " + table.contains("United"));
        System.out.println("Frequency of \"United\": " + table.frequency("United"));
        System.out.println("Term frequency of \"United\": " + table.termFrequency("United"));
    }
}
