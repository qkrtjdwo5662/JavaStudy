import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_2206 {
    public static int n;
    public static int m;

    public static int[] ry = {1,-1,0,0};
    public static int[] rx = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        ArrayList<int[]> walls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                int data = s.charAt(j)-'0';
                if(data == 1) walls.add(new int[]{i,j});
                map[i][j] = data;
            }
        }

        int answer = Integer.MAX_VALUE;

        if(bfs(new int[]{0,0}, map) != 0) answer = bfs(new int[]{0,0}, map);

        System.out.println(bfs(new int[]{0,0}, map));
        for (int i = 0; i < walls.size(); i++) {
            int[] wall = walls.get(i);
            System.out.println(bfs(wall, map));
            answer = Math.min(answer, bfs(wall, map));
        }
        System.out.println(answer);
    }
    public static int bfs(int[] wall, int[][] board){
        board[wall[0]][wall[1]] = 0;
        System.out.println(Arrays.deepToString(board));

        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        deque.addLast(new int[]{0,0});

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for(int i=0; i<4; i++){
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r<0 || c<0 || r>=n || c>=m) continue;

                if(board[r][c] == 1) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[]{r,c});
                    dist[r][c] = dist[now[0]][now[1]] + 1;
                }
            }
        }

        return dist[n-1][m-1] + 1;
    }
}
