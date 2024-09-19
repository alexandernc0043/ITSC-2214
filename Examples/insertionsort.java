public static void sort(int[] arr){
    for(int i = 1; i < arr.length; i++){
        
        for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--){
            int temp = arr[j];
            arr[j] = arr[j-1];
            arr[j-1] = temp;
        }
    }
}
public static void main(String[] args) {
    int arr[] = { 4, 7, 1 };
    sort(arr);
    for (int i : arr) {
        System.out.print(i + ",");
    }
    System.out.println();
}