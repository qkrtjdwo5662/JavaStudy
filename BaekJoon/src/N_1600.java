import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1600 {
    public static int k;
    public static int m;
    public static int n;
    public static int[][] board;
    public static int[] rx = {0,0,1,-1}; // 근접 이동
    public static int[] ry = {1,-1,0,0}; // 근접 이동

    public static int[] rrx = {-2, -1, 2, 1, 2, 1, -2, -1}; // 말 처럼 이동
    public static int[] rry = {-1, -2, -1, -2, 1, 2, 1, 2}; // 말 처럼 이동
    public static int min = Integer.MAX_VALUE;
    public static int[][] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = bfs(new int[]{0,0});

        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);

    }

    public static int bfs(int[] start){
        distance = new int[n][m];
        boolean[][][] visited = new boolean[n][m][k+1];
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        visited[start[0]][start[1]][k] = true;
        deque.addLast(new int[]{start[0],start[1], k});

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            if(now[0] == n-1 && now[1] == m-1){
                return distance[n-1][m-1];
            }
            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if (r < 0 || c < 0 || r >= n || c >= m) continue;

                if (board[r][c] != 0) continue;

                if (!visited[r][c][now[2]]) {
                    visited[r][c][now[2]] = true;
                    deque.addLast(new int[]{r, c, now[2]});
                    distance[r][c] = distance[now[0]][now[1]] + 1;
                }
            }
            if(now[2]>0){
                for (int i = 0; i < 8; i++) {
                    int r = now[0] + rry[i];
                    int c = now[1] + rrx[i];

                    if(r < 0 || c < 0 || r>=n || c>= m) continue;

                    if(board[r][c] != 0) continue;

                    if(!visited[r][c][now[2]-1]) {
                        visited[r][c][now[2] - 1] = true;
                        deque.addLast(new int[]{r, c, now[2]-1});
                        distance[r][c] = distance[now[0]][now[1]] + 1;
                    }
                }
            }


        }
        return min;
    }
}
