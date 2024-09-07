fun main(){
  println(value("listen".toCharArray()))
}

fun charValue(letter: Char): Int{
  return letter.code
}
fun value(list: Char[]): Int {
  var sum = 0
  for(Char c in list){
    sum -= charValue(c)
  }
  return sum
}
