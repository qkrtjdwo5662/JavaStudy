import java.util.Scanner;

public class Sum_Fountain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int d1 = sc.nextInt();
        int n2 = sc.nextInt();
        int d2 = sc.nextInt();

        n1 = n1 * d2;
        n2 = n2 * d1;

        int arr[] = new int[2];

        arr[0] = n1 + n2;
        arr[1] = d1 * d2;

        for (int i = 0; i < 2; i++) {
            System.out.print(arr[i]+" ");
        }

    }
}

