import java.util.Scanner;

public class N_24416 {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[41];
        System.out.println(fib(n));
        System.out.println(fibonacci(n));
    }
    static int fib(int n){
        if(n==1||n==2){
            return 1;
        }else return fib(n-1)+ fib(n-2);
    }

    static int fibonacci(int n){
        int answer = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <=n ; i++) {
            arr[i] = arr[i-1] + arr[i-2];
            answer++;
        }


        return answer;
    }
}
