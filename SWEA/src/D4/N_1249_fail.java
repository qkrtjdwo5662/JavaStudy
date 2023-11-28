package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1249_fail {
    public static int[] ry = {1, -1, 0, 0};
    public static int[] rx = {0, 0, 1, -1};
    public static int n;
    public static int[][] board;
    public static boolean[][] visited;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());


            board = new int[n][n];
            visited = new boolean[n][n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();

                for (int k = 0; k < n; k++) {
                    board[j][k] = s.charAt(k) - '0';
                }
            }

            answer =Integer.MAX_VALUE;
            dfs(new int[]{0, 0}, 0);
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int[] now, int sum){
        if(now[0] == n-1 && now[1] == n-1){
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int r = now[0] + ry[i];
            int c = now[1] + rx[i];

            if(r < 0 || c < 0 || r >= n || c >= n) continue;

            if(!visited[r][c]){
                visited[r][c] = true;
                dfs(new int[]{r, c}, sum + board[r][c]);
                visited[r][c] = false;
            }
        }
    }
}
