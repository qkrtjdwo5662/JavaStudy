import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_2178 {
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String sentence = st.nextToken();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(sentence.charAt(j)));
            }
        }

        System.out.println(bfs(map));
    }
    public static int bfs(int[][] map){
        int answer =0;
        ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        int[][] dist = new int[map.length][map[0].length];

        arrayDeque.addLast(new int[]{0,0});
        visited[0][0] = true;
        dist[0][0] = 1;

        while(!arrayDeque.isEmpty()){
            int[] now = arrayDeque.pollFirst();
            for (int i = 0; i < 4; i++) {
                int r = now[0] + rx[i];
                int c = now[1] + ry[i];
                if(r<0 || r>=map.length || c<0 || c>=map[0].length){
                   continue;
                }

                if(map[r][c] == 0) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    arrayDeque.addLast(new int[]{r,c});
                    dist[r][c] = dist[now[0]][now[1]] + 1;
                }
            }

        }
        answer = dist[dist.length-1][dist[0].length-1];

        return answer;
    }
}
