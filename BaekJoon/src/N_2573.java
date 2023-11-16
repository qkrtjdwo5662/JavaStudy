import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_2573 {
    public static int n;
    public static int m;
    public static int[][] board;
    public static boolean[][] visited;
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        int max = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;

                max = Math.max(max, num);
            }
        }
        int answer = 0;
        int count = 0;

        loop:
        while(count < 2){
            answer = answer+1;

            ArrayDeque<int[]> iceBerg = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int num = board[i][j];
                    if(num > 0) iceBerg.add(new int[]{i, j});
                }
            }
            visited = new boolean[n][m];
            melting(iceBerg, board);

            visited = new boolean[n][m];
            count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(!visited[i][j] && board[i][j] != 0){
                        count += 1;
                        bfs(new int[]{i, j});
                    }

                    if(count > 1) break loop;
                }
            }

        }

        if(max == answer) System.out.println(0);
        else System.out.println(answer);


    }

    public static void bfs(int[] start){
        visited[start[0]][start[1]] = true;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(start);

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r >= n || c >= m || r < 0 || c < 0){
                    continue;
                }

                if(board[r][c] == 0) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[]{r, c});
                }
            }
        }


    }

    public static void melting(ArrayDeque<int[]> iceBerg, int[][] board){
        while(!iceBerg.isEmpty()){
            int[] now = iceBerg.pollFirst();
            visited[now[0]][now[1]] = true;
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r >= n || c >= m || r < 0 || c < 0){
                    continue;
                }

                if(board[r][c] == 0 && !visited[r][c]) count += 1;

            }

            board[now[0]][now[1]] -= count;

            if(board[now[0]][now[1]] <= 0) board[now[0]][now[1]] = 0;
        }
    }
}
