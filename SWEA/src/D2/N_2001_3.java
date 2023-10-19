package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2001_3 {
    public static int[][] board;
    public static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            board = new int[n][n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    int num = Integer.parseInt(st.nextToken());

                    board[j][k] = num;
                }
            }
            int answer =0;
            for (int j = 0; j < n-m + 1; j++) {
                for (int k = 0; k < n-m +1 ; k++) {
                    answer = Math.max(answer, killFly(new int[]{j, k}));
                }
            }

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);

    }

    public static int killFly(int[] start){
        int count = 0;

        int y = start[0];
        int x = start[1];


        for (int i = y; i < y+m; i++) {
            for (int j = x; j <x + m ; j++) {
                count = count + board[i][j];
            }
        }

        return count;
    }
}
