import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_3109 {
    static int[] ry = {0, 1, -1};
    static int[] rx = {1, 1, 1};
    static int answer;

    static char[][] board;
    static int n;
    static int m;
    static boolean flag;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        visited = new boolean[n][m];
        answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for (int j = 0; j < s.length(); j++) {
                board[i][j] = s.charAt(j);
            }
        }

        backtrack(0, 0);
        System.out.println(answer);
    }

    static void backtrack(int nr, int nc){


        if(nc == m-1){
            if(nr == n-1){
                int count = 0;
                for (int i = 0; i < n; i++) {
                    if(visited[i][m-1]){
                        count++;
                    }
                }
                answer = Math.max(answer, count);
                return;
            }else backtrack(nr + 1, 0);
        }

        System.out.println(Arrays.deepToString(visited));

        for (int i = 0; i < 3; i++) {
            int r = nr + ry[i];
            int c = nc + rx[i];

            if(r < 0 || c<0 || r>= n || c>= m) continue;

            if(board[r][c] == 'x') continue;

            if(!visited[r][c]){
                visited[r][c] = true;
                backtrack(r, c);
                visited[r][c] = false;
            }

        }
    }
}
