public String reverseWord(String word)
{
  Stack<Character> stack = new Stack<Character>();
  char[] arr = word.toCharArray();
  for(int i = 0; i < arr.length; i++){
  	stack.push(arr[i]);
  }
  String reservered = "";
  while(!stack.isEmpty()){
  	reservered += stack.pop();
  }
    return reservered;
}

