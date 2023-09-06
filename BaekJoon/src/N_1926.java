import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_1926 {
    public static int n;
    public static int m;
    public static int[][] board;
    public static boolean[][] visited;
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};
    public static int count;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        count = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && board[i][j] == 1){
                    bfs(new int[]{i,j});
//                    System.out.println(visited[i][j]);
                    count++;
                }
            }
        }

        sb.append(count).append("\n");
        sb.append(answer);
        System.out.print(sb);
    }

    public static void bfs(int[] start){
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        deque.addLast(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;
        int width = 1;

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];


                if(r<0 || c<0 || r>=n || c>=m) continue;

                if(board[r][c] != 1) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[]{r,c});
                    width++;
                }


            }
        }
        answer = Math.max(answer, width);
    }
}
