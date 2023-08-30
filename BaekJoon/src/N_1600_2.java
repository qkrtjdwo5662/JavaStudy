import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1600_2 {
    public static int k;
    public static int m;
    public static int n;
    public static int[] rx = {0, 0, -1, 1};
    public static int[] ry = {1, -1, 0, 0};
    public static int[] rrx = {2, 2, -2, -2, 1, 1, -1, -1};
    public static int[] rry = {1, -1, 1, -1, 2, -2, 2, -2};
    public static int[][] board;
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
        if(m==1 && n==1) {
            System.out.println(0);
            return;
        }


        bfs();
        if(distance[n-1][m-1] == 0) System.out.println(-1);
        else System.out.println(distance[n-1][m-1]);
    }

    public static void bfs(){
        boolean[][][] visited = new boolean[n][m][k+1];
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        distance = new int[n][m];

        visited[0][0][k] = true;
        deque.addLast(new int[]{0,0,k});

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            if(now[0] == n-1 && now[1] == m-1) return;

            if(now[2] > 0){
                for (int i = 0; i < 8; i++) {
                    int r = now[0] + rry[i];
                    int c = now[1] + rrx[i];

                    if(r <0 || c<0 || r>=n || c>= m) continue;

                    if(board[r][c] == 1) continue;

                    if(!visited[r][c][now[2]-1]){
                        visited[r][c][now[2]-1] = true;
                        deque.addLast(new int[]{r,c,now[2]-1});
                        distance[r][c] = distance[now[0]][now[1]] + 1;
                    }
                }

            }

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r <0 || c<0 || r>=n || c>= m) continue;

                if(board[r][c] == 1) continue;

                if(!visited[r][c][now[2]]){
                    visited[r][c][now[2]] = true;
                    deque.addLast(new int[]{r,c,now[2]});
                    distance[r][c] = distance[now[0]][now[1]] + 1;
                }
            }
        }
    }
}
