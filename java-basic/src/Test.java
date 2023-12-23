public class Test {
    public static void main(String[] args) {
        int[][] arr = new int[2][2];

        System.out.println(arr[0][0]);
        change(arr, 22);
        System.out.println(arr[0][0]);
    }
    public static void change(int[][] arr, int a){
        arr[0][0] = a;
    }
}
