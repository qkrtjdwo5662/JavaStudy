import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_7576_4 {
    public static int n;
    public static int m;

    public static int[][] map;
    public static ArrayDeque<int[]> deque;
    public static boolean[][] visited;

    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        deque = new ArrayDeque<>();
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());

                map[i][j] = num;
                if(num == 1){
                    deque.addLast(new int[]{i, j});
                    visited[i][j] = true;
                }

            }
        }

        bfs();
        int day = 0;

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if(map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                day = Math.max(day, map[i][j]);
            }
        }

        System.out.println(day - 1);
    }

    public static void bfs(){
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r<0 || c<0 || r>=n || c>=m) continue;

                if(map[r][c] == -1) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[] {r, c});
                    map[r][c] = map[now[0]][now[1]] + 1;
                }
            }
        }
    }
}
