package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2001_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] board = new int[n+1][n+1];
            int[][] sum = new int[n+1][n+1];

            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    board[j][k] = num;

                    sum[j][k] = board[j][k];

                    if(j>0) sum[j][k] += sum[j-1][k];
                    if(k>0) sum[j][k] += sum[j][k-1];
                    if(j>0 && k>0) sum[j][k] -= sum[j-1][k-1];


                }
            }

            int max = 0;
            for (int j = 0; j <= n-m ; j++) {
                for (int k = 0; k <= n-m ; k++) {
                    int count = sum[j+m][k+m] - sum[j][k+m] - sum[j+m][k] + sum[j][k];
                    max = Math.max(max, count);
                }
            }

            for (int j = 0; j < n+1; j++) {
                for (int k = 0; k < n+1; k++) {
                    System.out.print(board[j][k]  + " ");
                }
                System.out.println();
            }
            System.out.println();

            for (int j = 0; j < n+1; j++) {
                for (int k = 0; k < n+1; k++) {
                    System.out.print(sum[j][k]  + " ");
                }
                System.out.println();
            }

            System.out.println(max);
        }
    }
}
