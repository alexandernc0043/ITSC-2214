## Write a hash function for a string key that adds the letters in the key

### Example
```java
public class HashFunction {
    public static int hashFunction(String key) {
        int hashValue = 0;

        // Iterate through each character in the string
        for (int i = 0; i < key.length(); i++) {
            // Add the ASCII value of the character to hashValue
            hashValue += (int) key.charAt(i);
        }

        return hashValue;
    }

    public static void main(String[] args) {
        String key = "example";
        System.out.println("Hash value: " + hashFunction(key));
    }
}
```