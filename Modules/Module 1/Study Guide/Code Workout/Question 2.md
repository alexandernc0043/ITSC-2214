## Write a method that does some manipulation of a string

### Example
```java
String str = "Hello World";
char strArray[] = str.toCharArray();
String newStr = "";

for(int i = strArray.length - 1; i >= 0; i--){
	newStr += strArray[i];
}
System.out.println(newStr);
// Output  "dlroW olleH"
```