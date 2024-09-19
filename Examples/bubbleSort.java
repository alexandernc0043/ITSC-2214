public static void bubbleSort(int[] list){
  int n = list.length;
  for(int i = 0; i < n - 1; i++){
    for(int j = 0; j < n - i - 1; j++){
      if(list[j] > list[j+1]){
        int temp = list[j];
        list[j] = list[j+1];
        list[j+1] = temp;
      }
    }
  }
}
public static void main(String[] args){
  int sort[] = {3, 1, 5, 6, 8};
  bubbleSort(sort);
  for (int i : sort) {
    System.out.print(i + ",");
  }
  System.out.println();
}
