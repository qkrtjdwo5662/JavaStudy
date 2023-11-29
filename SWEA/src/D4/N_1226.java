package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_1226 {
    public static int n;
    public static int[][] board;
    public static boolean[][] visited;
    public static ArrayDeque<int[]> deque;

    public static int[] ry = {1, -1, 0, 0};
    public static int[] rx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();

        int tc = 10;

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            n = 16;

            board = new int[n][n];
            visited = new boolean[n][n];

            deque = new ArrayDeque<>();
            int[] end = new int[2];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int k = 0; k < n; k++) {
                    int num = s.charAt(k) -'0';
                    board[j][k] = num;

                    if(num == 2){
                        deque.add(new int[]{j, k});
                    }else if(num == 3){
                        end[0] = j;
                        end[1] = k;
                    }
                }
            }
            bfs();

            if(visited[end[0]][end[1]]){
                sb.append("#").append(i).append(" ").append(1).append("\n");
            }else{
                sb.append("#").append(i).append(" ").append(0).append("\n");
            }

        }
        System.out.println(sb);
    }

    public static void bfs(){
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r < 0 || c<0 || r>=n || c>=n) continue;

                if(board[r][c] == 1) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[]{r, c});
                }
            }

        }
    }
}
