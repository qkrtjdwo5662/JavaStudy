import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_4179 {
    public static int n;
    public static int m;
    public static char[][] board;
    public static int answer;
    public static ArrayDeque<int[]> deque;
    public static ArrayDeque<int[]> fireDeque;
    public static boolean[][] visited;
    public static boolean[][] fireVisited;
    public static int[] ry = {1, -1, 0, 0};
    public static int[] rx = {0, 0, 1, -1};
    public static int[][] dist;
    public static boolean check;
    public static int[] start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        deque = new ArrayDeque<>();
        fireDeque = new ArrayDeque<>();
        visited = new boolean[n][m];
        fireVisited = new boolean[n][m];
        answer = 0;
        dist = new int[n][m];
        start = new int[2];
        check = false;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for (int j = 0; j < m; j++) {
                if(s.charAt(j) == 'J'){
                    deque.addLast(new int[]{i, j});
                    visited[i][j] = true;
                    dist[i][j] = 1;
                    start = new int[]{i, j};
                }else if(s.charAt(j) == 'F'){
                    fireDeque.addLast(new int[]{i, j});
                    fireVisited[i][j] = true;
                }
                board[i][j] = s.charAt(j);
            }
        }
        if(start[0] == 0 || start[1] == 0 || start[0] == n-1 || start[1] == m-1) {
            System.out.println(1);
            return;
        }
        bfs();
        if(!check){
            sb.append("IMPOSSIBLE").append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(){
        while(!deque.isEmpty()){
            int size = deque.size();
            int fireSize = fireDeque.size();
            for (int i = 0; i < fireSize; i++) {
                int[] now = fireDeque.pollFirst();

                for (int j = 0; j < 4; j++) {
                    int r = now[0] + ry[j];
                    int c = now[1] + rx[j];
                    if(r < 0 || c< 0|| r>= n || c>= m) continue;

                    if(board[r][c] == '#') continue;

                    if(!fireVisited[r][c]){
                        fireVisited[r][c] = true;
                        board[r][c] = 'F';
                        fireDeque.addLast(new int[]{r, c});
                    }

                }
            }

            for (int i = 0; i < size; i++) {
                int[] now = deque.pollFirst();

                for (int j = 0; j < 4; j++) {
                    int r = now[0] + ry[j];
                    int c = now[1] + rx[j];

                    if(r < 0 || c< 0|| r>= n || c>= m) continue;

                    if(board[r][c] != '.') continue;


                    if(!visited[r][c]){
                        visited[r][c] = true;
                        deque.addLast(new int[]{r, c});
                        dist[r][c] = dist[now[0]][now[1]] +1;

                        if(r == n-1 || r==0 || c== m-1 || c== 0){
                            System.out.println(dist[r][c]);
                            check = true;
                            return;
                        }
                    }


                }
            }
        }

    }
}
