import java.util.Scanner;

public class Array_Solution9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[][] = new int[N][N];
        int max = 0;
        int sum = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        //열의 합
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                sum = sum + arr[j][i];
                if (max < sum) {
                    max = sum;
                }
            }
            sum = 0;
        }
        //행 합
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                sum = sum + arr[i][j];
                if (max < sum) {
                    max = sum;
                }
            }
            sum = 0;
        }
        //대각선 1
        for(int i=0; i<N; i++){
            sum = sum + arr[i][i];
            if (max < sum) {
                max = sum;
            }
        }
        sum=0;
        //대각선 2
        for(int i=N-1; i>=0; i--){
            for(int j=0; j<N; j++) {
                sum = sum + arr[i][j];
                if (max < sum) {
                    max = sum;
                }
            }
            sum = 0;
        }
        System.out.print(max);

    }
}
