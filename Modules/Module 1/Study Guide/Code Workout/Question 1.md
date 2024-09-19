## Write a method that loops over arrays to find an item or determine some attribute of the array

### Example 
```java
String words[] = {"Hello", "World", "String", "Array"};
// Find index of String "World"
for(int i = 0; i < words.length; i++){
	if(words[i] == "World") System.out.println(i);
}
// Output "1"
```