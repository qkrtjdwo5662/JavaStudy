import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_2206 {
    public static int n;
    public static int m;

    public static int[][] map;

    public static int[] ry = {1,-1,0,0};
    public static int[] rx = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                int data = s.charAt(j)-'0';
                map[i][j] = data;
            }
        }

        bfs();

    }
    public static void bfs(){
        boolean[][][] visited = new boolean[n][m][2];
        int[][] dist = new int[n][m];
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        dist[0][0] = 1;
        deque.addLast(new int[]{0,0,0});

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for(int i=0; i<4; i++){
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r<0 || c<0 || r>=n || c>=m) continue;

                if(map[r][c] == 1) { // 벽 O
                    if(now[2] == 0 && !visited[r][c][1]){
                        visited[r][c][now[2]] = true;
                        dist[r][c] = dist[now[0]][now[1]] + 1;
                        deque.addLast(new int[]{r, c, 1});
                    }
                }else{ // 벽 X
                    if(!visited[r][c][now[2]]){
                        visited[r][c][now[2]] = true;
                        dist[r][c] = dist[now[0]][now[1]] + 1;
                        deque.addLast(new int[]{r, c, now[2]});
                    }
                }

                if(r == n-1 && c == m-1) {
                    if(r == 0 && c == 0 ){
                        System.out.println(1);
                        return;
                    }
                    System.out.println(dist[r][c]);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
