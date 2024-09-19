## [While Loops](https://www.w3schools.com/java/java_while_loop.asp)
```java
while (condition) {
  Code to be executed
}
```
## [For Loops](https://www.w3schools.com/java/java_for_loop.asp)
```java
for (statement 1; statement 2; statement 3) {
  Code to be executed
}
```
## [For Each Loop](https://www.w3schools.com/java/java_foreach_loop.asp)
```java
  for (type varName : arrayName) {
   Code to be executed
  }
```

## Examples
```java
while (true) {
    Code to be executed
}
```
```java
while (foo < foo2) {
    Code to be executed
}
```
```java
for(int i = 0; i < array.length; i++){
    Code to be executed
}
```
```java
for(int i : array){ 
  Code to be executed
}
```
```java
for(String s : array){ 
  Code to be executed
}
```
# [Java if Statements](https://www.w3schools.com/java/java_conditions.asp)
```java
if(condition) {
    block of code to be executed if the condition is true
}
else if (condition) {
    block of code to be executed if the condition is true
}
else {
    block of code to be executed if the condition is true
}
```
# Example
```java
if (20 > 18) {
  System.out.println("20 is greater than 18");
}
```
## Break Statement
```
You have already seen the break statement used in an earlier chapter of this tutorial. It was used to "jump out" of a switch statement.

The break statement can also be used to jump out of a loop.
```
This example stops the loop when i is equal to 4:

```java
for (int i = 0; i < 10; i++) {
  if (i == 4) {
    break;
  }
  System.out.println(i);
}
```
## [Arrays](https://www.w3schools.com/java/java_arrays.asp)
```java
int numbers[] = {1, 2 ,3};
String words[] = {"Hello", "World"};
int maxOfFive[5]; // has a size limit of 5
word[0] // "Hello"
```
## Iteration over arrays using index loops, for-each loops and iterators
```java
String words[] = {"Hello", "World"};
for(String str : words){
  System.out.println(str);
}
/*
 * Hello
 * World
*/
for(int i = 0; i < words.length; i++){
  System.out.println(words[i]);
}
/*
 * Hello
 * World
*/
```
## Comparing objects with equals, a.compareTo(b), and compare(a, b)
```java
objectOne.compareTo(objectTwo);
```
```
If objectOne is less than objectTwo
    Returns a negative number (-1)

if objectOne is equal to objectTwo  
    Returns 0

Else / objectOne is greater to objectTwo
    Returns a postive number (1)
```
## [Linear Search](https://www.w3schools.com/dsa/dsa_algo_linearsearch.php)
The Linear Search algorithm searches through an array and returns the index of the value it searches for.
```java
public int linearSearch(int[] array, int search){
  for(int i = 0; i < array.length; i++){ // loop through the list
    if(array[i] == search){ // if the item at index i is/equal to search return i (index)
      return i;
    }
  }
  return null; // Int "search" was not in array
}
```

## Generics
Basically its like Anything
Better explantion https://www.baeldung.com/java-generics , https://www.geeksforgeeks.org/generics-in-java/

```java
public void print(E generic){
  System.out.println(generic);
}