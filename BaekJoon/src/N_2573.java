import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_2573 {
    public static int n;
    public static int m;
    public static int[][] board;
    public static boolean[][] visited;
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];


        int answer = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }


        loop:
        while(true){
            count = 0;
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(!visited[i][j] && board[i][j] != 0){
                        bfs(new int[]{i, j});
                        count += 1;
                    }

                }
            }

            if(count == 0){
                System.out.println(0);
                break;
            }else if(count > 1){
                System.out.println(answer);
                break;
            }

            ArrayDeque<int[]> iceBerg = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int num = board[i][j];
                    if(num > 0) iceBerg.add(new int[]{i, j});
                }
            }
            visited = new boolean[n][m];
            melting(iceBerg, board);
            answer += 1;
        }



    }

    public static void bfs(int[] start){
        visited[start[0]][start[1]] = true;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(start);

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r >= n || c >= m || r < 0 || c < 0){
                    continue;
                }

                if(board[r][c] == 0) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[]{r, c});
                }
            }
        }


    }

    public static void melting(ArrayDeque<int[]> iceBerg, int[][] board){
        while(!iceBerg.isEmpty()){
            int[] now = iceBerg.pollFirst();
            visited[now[0]][now[1]] = true; // 기존 좌표가 0되는 경우를 구분

            int count = 0; // 상하좌우 0의 개수
            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r >= n || c >= m || r < 0 || c < 0){
                    continue;
                }

                if(board[r][c] == 0 && !visited[r][c]) count += 1;

            }

            board[now[0]][now[1]] -= count;

            if(board[now[0]][now[1]] <= 0) board[now[0]][now[1]] = 0;
        }
    }
}
