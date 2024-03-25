import java.io.*;
import java.util.*;

public class N_7727 {
    static class Friend{
        int x;
        int y;

        public Friend(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int n;
    static int m;
    static int[][] board;
    static boolean[][] visited;
    static Friend[] friends;
    static int[] ry = {0, 0, 1, -1};
    static int[] rx = {1, -1, 0, 0};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        friends = new Friend[m];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }

        int sum = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            Friend friend = new Friend(y, x);
            friends[i] = friend;

            sum += board[y][x];
            visited[y][x] = true;
        }

        answer = 0;

        backtrack(1, 0, sum);

        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void backtrack(int time, int depth, int sum) {
        if(time == 4) {
            answer = Math.max(answer, sum);
            return;
        }else {
            if(depth < m) {
                Friend now = friends[depth];
                int ny = now.y;
                int nx = now.x;

                for (int i = 0; i < 4; i++) {
                    int r = now.y + ry[i];
                    int c = now.x + rx[i];

                    if(!canMove(r, c)) continue;

                    if(!visited[r][c]) {
                        visited[r][c] = true;
                        now.y = r;
                        now.x = c;

                        backtrack(time, depth + 1, sum + board[r][c]);

                        visited[r][c] = false;
                        now.y = ny;
                        now.x = nx;
                    }else {
                        now.y = r;
                        now.x = c;

                        backtrack(time, depth + 1, sum);

                        now.y = ny;
                        now.x = nx;
                    }

                }
            }else {
                backtrack(time + 1, 0, sum);
            }

        }



    }

    static boolean canMove(int y, int x) {
        if(y < 1 || x < 1 || y > n || x > n) return false;

        return true;
    }
}
