package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_1210 {
    public static int[] ry = {0, 0, -1};
    public static int[] rx = {1, -1, 0};
    public static int[][] board;
    public static boolean[][] visited;
    public static ArrayDeque<int[]> deque;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = 10;

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            board = new int[100][100];
            deque = new ArrayDeque<>();
            visited = new boolean[100][100];

            for (int j = 0; j < 100; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 100 ; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    board[j][k] = num;
                    if(num == 2) {
                        deque.add(new int[]{j, k});
                        visited[j][k] = true;
                    }
                }
            }
            bfs();
            int answer = -1;
            for (int j = 0; j < 100; j++) {
                if(visited[0][j]){
                    answer = j;
                }
            }
            sb.append("#").append(i).append(" ").append(answer).append("\n");

        }
        System.out.println(sb);
    }

    public static void bfs(){
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 3; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r < 0 || c<0 || r>= 100 || c>= 100) continue; // 범위 벗어나면

                if(board[r][c] == 0) continue; // 0이면


                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[]{r, c});
                    break;

                }
            }
        }

    }
}
