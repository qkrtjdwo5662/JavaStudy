import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_1012 {
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 가로
            int n = Integer.parseInt(st.nextToken()); // 세로
            int k = Integer.parseInt(st.nextToken()); // 배추 갯 수

            int[][] map = new int[n][m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            } // map 완성

            // 탐색 시작
            boolean[][] visited = new boolean[n][m];
            ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();
            int count = 0;

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if(map[j][l]==1 && !visited[j][l]){ // map 원소 1이고 방문하지 않은 곳만
                        visited[j][l] = true;
                        arrayDeque.addLast(new int[]{j,l});
                        count++;
                        while(!arrayDeque.isEmpty()){
                            int[] now = arrayDeque.pollFirst();
                            for (int o = 0; o < 4; o++) {
                                int r = now[0] + ry[o];
                                int c = now[1] + rx[o];

                                if(r<0 || c<0 || r >= n || c >= m) continue;

                                if(map[r][c] == 0) continue;

                                if(!visited[r][c]){
                                    visited[r][c] = true;
                                    arrayDeque.addLast(new int[]{r, c});
                                }
                            }
                        }
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);

    }
}
