package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1954 {
    public static int[] rx = {1, 0, -1, 0};
    public static int[] ry = {0, 1, 0, -1};
    public static int num;
    public static int n;
    public static int[][] map;
    public static boolean[][] visited;
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            visited = new boolean[n][n];
            num = 0;
            if(n == 1){
                sb.append("#").append(i).append("\n");
                sb.append(1).append("\n");
                continue;
            }
            dfs(new int[]{0, 0}, 0);

            sb.append("#").append(i).append("\n");
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    sb.append(map[j][k]).append(" ");
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);


    }

    public static void dfs(int[] now, int d){
        if(visited[now[0]][now[1]]) return;

        visited[now[0]][now[1]] = true;
        map[now[0]][now[1]] = ++num;
        count++;

        int r = now[0] + ry[d];
        int c = now[1] + rx[d];

        if(r <0 || c<0 || r>= n || c>= n) {
            d = (d+1) % 4;

            r = now[0] + ry[d];
            c = now[1] + rx[d];
        }

        if(visited[r][c]){
            d = (d+1) % 4;

            r = now[0] + ry[d];
            c = now[1] + rx[d];
        }

        dfs(new int[]{r, c}, d);


    }
}
