import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1520 {
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};
    public static int[][] map;
    public static int[][] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        count = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                count[i][j] = -1;
            }
        }

        count[n-1][m-1] = 1; // memo initializing
        dfs(new int[]{0,0});

        System.out.println(count[0][0]);
    }
    public static int dfs(int[] now){
        if(count[now[0]][now[1]] > -1){ // 방문했다면 count[][]>0
            return count[now[0]][now[1]];
        }

        count[now[0]][now[1]] = 0;

        for (int i = 0; i < 4; i++) { // 상하좌우 이동
            int r = now[0] + ry[i]; // 상하
            int c = now[1] + rx[i]; // 좌우

            if(r<0 || r>= map.length || c<0 || c>= map[0].length){
                continue;
            }

            if(map[now[0]][now[1]] > map[r][c]){
                count[now[0]][now[1]] = count[now[0]][now[1]] + dfs(new int[] {r,c});
            }
        }

        return count[now[0]][now[1]];
    }
}
