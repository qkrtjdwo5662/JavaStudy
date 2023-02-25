import java.util.Scanner;

public class N_1904 {
    static int arr[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[1000001];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <=n ; i++) {
            arr[i] = (arr[i-2] + arr[i-1])%15746;

        }
        System.out.println(arr[n]);

    }
}
