import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1520_2 {
    public static int[][] map;
    public static int[][] count;
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};
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
        count[n-1][m-1] = 1; // 마지막에서 마지막으로 갈 수 있는 건 1가지
        dfs(new int[]{0,0}); // 0,0 부터 쭉 탐색

        System.out.println(count[0][0]);

    }
    public static int dfs(int[] now){
        if(count[now[0]][now[1]]>-1){
            return count[now[0]][now[1]];
        }
        count[now[0]][now[1]] = 0;

        for (int i = 0; i < 4; i++) {
            int r = now[0] + ry[i];
            int c = now[1] + rx[i];

            if(r<0 || c<0 || r>=map.length || c>=map[0].length) continue;

            if(map[now[0]][now[1]] > map[r][c]){
                count[now[0]][now[1]] = count[now[0]][now[1]] + dfs(new int[] {r,c});
            }
        }

        return count[now[0]][now[1]];
    }
}
