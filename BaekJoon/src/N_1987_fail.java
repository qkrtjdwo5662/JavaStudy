import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1987_fail {
    public static int n;
    public static int m;
    public static boolean[] used;
    public static int answer;
    public static char[][] board;
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        answer = 0;
        used = new boolean['Z'-'A' + 1];

        dfs(new int[]{0,0}, 0);

        System.out.println(answer);
    }
    public static void dfs(int[] now, int count){
        if(used[board[now[0]][now[1]] - 'A']) {
            answer = Math.max(answer, count);
            return;
        }

        used[board[now[0]][now[1]] - 'A'] = true;

        for (int i = 0; i < 4; i++) {
            int r = now[0] + ry[i];
            int c = now[1] + rx[i];

            if(r < 0 || c < 0 || r >= n || c >= m) continue;

            dfs(new int[]{r,c}, count+1);

        }

        used[board[now[0]][now[1]] - 'A'] = false;
    }
}
