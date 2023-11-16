import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_14904 {
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};

    public static int n;
    public static int m;
    public static int[][] board;
    public static int[][] distance;
    public static boolean[][] visited;
    public static ArrayDeque<int[]> deque;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];

        deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;

                if(num == 2){
                    deque.addLast(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(distance[i][j] == 0){
                    if(!visited[i][j] && board[i][j]!= 0) sb.append(-1).append(" ");
                    else sb.append(0).append(" ");
                }else{
                    sb.append(distance[i][j]).append(" ");
                }

            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(){
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r < 0 || c < 0 || r >= n || c>= m ) continue;

                if(board[r][c] == 0) {
                    visited[r][c] = true;
                    continue;
                }

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[]{r,c});
                    distance[r][c] = distance[now[0]][now[1]] + 1;
                }
            }
        }
    }

}
