import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_7576_2 {
    public static int[][] board;
    public static ArrayList<int[]> ripe;
    public static int[][] result;
    public static int m;
    public static int n;

    public static int[] ry = {1, -1, 0, 0};
    public static int[] rx = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        ripe = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;

                if(num == 1) ripe.add(new int[]{i,j});
            }
        }

        bfs();
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(result[i][j] == 0 && board[i][j] != -1) {

                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, result[i][j]);
            }
        }

        sb.append(max-1);
        System.out.println(sb);
    }

    public static void bfs(){
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        result = new int[n][m];

        for (int i = 0; i < ripe.size(); i++) {
            int[] info = ripe.get(i);

            visited[info[0]][info[1]] = true;
            deque.addLast(info);
            result[info[0]][info[1]] = 1;
        }

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r <0 || c< 0 || r>= n || c >= m) continue;

                if(board[r][c] == -1) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[]{r,c});
                    result[r][c] = result[now[0]][now[1]] + 1;
                }

            }
        }

    }
}
