import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_2178_3 {
    public static int n;
    public static int m;
    public static int[][] board;
    public static int[][] dist;
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                int num = s.charAt(j) - '0';
                board[i][j] = num;
            }
        }

        bfs(new int[]{0,0});

        System.out.println(dist[n-1][m-1]);
    }

    public static void bfs(int[] start){
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        dist[start[0]][start[1]] = 1;
        visited[start[0]][start[1]] = true;
        deque.addLast(start);

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r < 0 || c < 0 || r >= n || c >= m) continue;

                if(board[r][c] == 0) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[]{r,c});
                    dist[r][c] = dist[now[0]][now[1]] + 1;
                }
            }
        }

    }
}
