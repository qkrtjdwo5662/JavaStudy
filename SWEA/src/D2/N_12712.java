package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_12712 {
    public static int n;
    public static int m;
    public static int[][] board;
    public static int[] rx = {0, 0, 1, -1, 1, -1, -1, 1};
    public static int[] ry = {1, -1, 0, 0, 1, 1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            board = new int[n][n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    board[j][k] = num;
                }
            }

            int max= 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    max = Math.max(max, countPlus(new int[]{j,k}));
                    max = Math.max(max, countX(new int[]{j,k}));
                }
            }
            sb.append("#").append(i).append(" ").append(max).append("\n");

        }
        System.out.println(sb);
    }

    static int countPlus(int[] start){
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            int index = 0;
            int r = start[0];
            int c = start[1];
            while(index < m-1){
                r += ry[i];
                c += rx[i];

                if(r < 0 || r>= n || c<0 || c>= n) break;

                answer += board[r][c];

                index ++;
            }
        }

        answer += board[start[0]][start[1]];

        return answer;
    }

    static int countX(int[] start){
        int answer = 0;
        for (int i = 4; i < 8; i++) {
            int index = 0;
            int r = start[0];
            int c = start[1];
            while(index < m-1){
                r += ry[i];
                c += rx[i];

                if(r < 0 || r>= n || c<0 || c>= n) break;

                answer += board[r][c];

                index ++;
            }
        }

        answer += board[start[0]][start[1]];

        return answer;
    }
}
