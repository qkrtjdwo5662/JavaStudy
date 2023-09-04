import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_16236 {
    public static int n;
    public static int[][] map;
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        int[] start = new int[2];
        int count = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int data = Integer.parseInt(st.nextToken());
                map[i][j] = data;
                if(data == 9){
                    start[0] = i;
                    start[1] = j;
                }else if(data != 0){
                    count++;
                }
            }
        }

        if(count == 0) {
            System.out.println(0);
            return;
        }

        bfs(start, count);

    }

    public static void bfs(int[] start, int count){
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        deque.addLast(start);
        visited[start[0]][start[1]] = true;

        // 먹이 수가 1마리면 : 거리가 가장 가까운 물고기
        // 먹이 수가 1마리 초과라면 거리를 움직인 값이 최소가 되도록


        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r<0 || c<0 || r>=n || c>=n) continue;
            }
        }
    }
}
