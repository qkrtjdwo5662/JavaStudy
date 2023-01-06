import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr[] = new int[N];
        arr[0] =1;
        arr[1] =1;
        for(int i=2; i<arr.length; i++) {
            arr[i] =arr[i-2] + arr[i-1];
        }
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
