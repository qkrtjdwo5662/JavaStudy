import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_7576 {
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); // 가로
        int n = Integer.parseInt(st.nextToken()); // 세로

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] == 1){
                    visited[i][j] = true;
                    arrayDeque.addLast(new int[]{i, j});
                }
            }
        }
        while(!arrayDeque.isEmpty()){
            int[] now = arrayDeque.pollFirst();
            for (int k = 0; k < 4; k++) {
                int r = now[0] + ry[k];
                int c = now[1] + rx[k];

                if(r < 0 || c < 0 || r >= n || c >= m) continue;

                if(map[r][c] == -1) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    arrayDeque.addLast(new int[]{r, c});
                    map[r][c] = map[now[0]][now[1]] + 1;
                }

            }
        }


        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                if(map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, map[i][j]);
            }
        }
        System.out.println(answer-1);
    }
}
