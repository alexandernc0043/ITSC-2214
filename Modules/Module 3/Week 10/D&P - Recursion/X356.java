public class X356 {
    public static int perrinNumber(int n) {
        switch(n){
        case 0:
            return 3;
        case 1:
            return 0;
        case 2:
            return 2;
        default:
            return perrinNumber(n-2) + perrinNumber(n-3);
        }
    }
    public static void main(String[] args){
        System.out.println(perrinNumber(0)); // 3
        System.out.println(perrinNumber(1)); // 0
        System.out.println(perrinNumber(2)); // 2
        System.out.println(perrinNumber(3)); // 3
    }
}
