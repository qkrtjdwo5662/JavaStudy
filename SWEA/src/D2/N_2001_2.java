package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2001_2 {
    public static int n;
    public static int m;
    public static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= tc; i++) {
            st =new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            board = new int[n][n];
            for (int j = 0; j < n; j++) {
                st =new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    board[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for (int j = 0; j < n-m + 1; j++) {
                for (int k = 0; k <n -m + 1 ; k++) {
                    answer = Math.max(answer, count(j, k));
                }
            }

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static int count(int y, int x) {
        int answer = 0;
        for (int i = y; i < y+m; i++) {
            for (int j = x; j <x+m ; j++) {
                answer = answer + board[i][j];
            }
        }
        return answer;
    }
}
