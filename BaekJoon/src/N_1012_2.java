import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_1012_2 {
    public static int n;
    public static int m;
    public static boolean[][] visited;
    public static int[][] board;

    public static int[] ry = {1, -1, 0, 0};
    public static int[] rx = {0, 0, 1, -1};
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            // m*n 정점의 개수

            int k = Integer.parseInt(st.nextToken()); // 간선 길이

            board = new int[n][m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                board[y][x] = 1;
            }

            visited = new boolean[n][m];
            answer = 0;
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if( board[j][l] == 1 && !visited[j][l]){
                        bfs(new int[]{j, l});
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
    public static void bfs(int[] start){
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        deque.addLast(start);
        visited[start[0]][start[1]] = true;
        answer++;

        if(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            // 인접 정점 방문
            // 상하 좌우

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r < 0 || c < 0 || r>=n || c>= m) continue;

                if(board[r][c] == 0) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[]{r, c});
                }
            }
        }
    }
}
