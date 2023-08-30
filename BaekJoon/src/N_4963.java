import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_4963 {
    public static boolean[][] visited;
    public static int[] rx = {0,0,1,-1, 1,-1,-1, 1 };
    public static int[] ry = {1,-1, 0, 0,1,1,-1, -1 };
    public static int n;
    public static int m;
    public static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String s = "";
        StringBuilder sb = new StringBuilder();

        while(!(s = br.readLine()).equals("0 0")){
            st = new StringTokenizer(s);

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new boolean[n][m];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(!visited[i][j] && map[i][j] == 1){
                        dfs(new int[]{i,j});
                        count++;
                    }

                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int[] now){
        if(visited[now[0]][now[1]]) return;

        visited[now[0]][now[1]] = true;

        for (int i = 0; i < 8; i++) {
            int r = now[0] + ry[i];
            int c = now[1] + rx[i];
            if(r <0 || c<0 || r>= n || c>=m ) continue;


            if(map[r][c] == 0) continue;

            dfs(new int[]{r,c});

        }
    }
}
