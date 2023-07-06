import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2468 {
    public static int answer =0;
    public static boolean[][] visited;
    public static int[] rx ={0,0,1,-1};
    public static int[] ry ={1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                max = Math.max(max, num);
            }
        }

        for (int i = 0; i <max ; i++) {
            visited = new boolean[n][n];
            int[][] temp = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    temp[j][k] = map[j][k] - i;
                }
            }

            int count =0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(temp[j][k]>0 && !visited[j][k]){
                        dfs(new int[]{j,k}, temp);
                        count++;
                    }

                }
            }

            answer = Math.max(count, answer);
        }

        System.out.println(answer);

    }
    public static void dfs(int[] now, int[][] temp){
        if(visited[now[0]][now[1]]){
            return;
        }

        visited[now[0]][now[1]] = true; // true 처리 해주고

        for (int i = 0; i < 4 ; i++) {
            int r = now[0] + ry[i];
            int c = now[1] + rx[i];

            if(r<0 || c<0 || r>=temp.length || c>=temp.length) continue;

            if(temp[r][c]>0){
                dfs(new int[]{r,c}, temp);
            }
        }
    }
}
