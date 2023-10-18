import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class N_10026_2 {
    public static int[][] board;
    public static boolean[][] visited;
    public static int n;
    public static int[] ry = {0, 0, 1, -1};
    public static int[] rx = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == 'R') board[i][j] = 0;
                else if(s.charAt(j) == 'G') board[i][j] = 1;
                else if (s.charAt(j) == 'B') board[i][j] = 2;
            }
        }

        // R : 0
        // G : 1
        // B : 2

        visited = new boolean[n][n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    normal(new int[]{i, j});
                    answer++;
                }
            }
        }
        sb.append(answer).append(" ");

        visited = new boolean[n][n];
        answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && (board[i][j] == 0 || board[i][j] == 1)) {
                    rg(new int[]{i, j});
                    answer++;
                }
                else if(!visited[i][j]) {
                    normal(new int[]{i, j});
                    answer++;
                }
            }
        }
        sb.append(answer);
        System.out.println(sb);

    }

    public static void rg(int[] start){
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        visited[start[0]][start[1]] = true;
        deque.add(start);

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r <0 || c<0 || r>=n || c>= n) continue;

                if(board[r][c] != 0 && board[r][c] != 1) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[]{r,c});
                }
            }
        }
    }

    public static void normal(int[] start){
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        int color = board[start[0]][start[1]];
        visited[start[0]][start[1]] = true;
        deque.add(start);

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r <0 || c<0 || r>=n || c>= n) continue;

                if(board[r][c] != color) continue;


                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[]{r,c});
                }
            }
        }


    }
}
