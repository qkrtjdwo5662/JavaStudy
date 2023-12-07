package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_1227 {
    public static int[][] board;
    public static boolean[][] visited;
    public static int[] ry = {1, -1, 0, 0};
    public static int[] rx = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = 10;

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());


            board = new int[100][100];

            int[] start = new int[2];
            int[] end = new int[2];

            for (int j = 0; j < 100; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int k = 0; k < 100; k++) {
                    int num = s.charAt(k) - '0';
                    board[j][k] = num;
                    if(num == 2) {
                        start[0] = j;
                        start[1] = k;
                    }else if(num == 3){
                        end[0] = j;
                        end[1] = k;
                    }
                }
            }
            visited = new boolean[100][100];
            bfs(start);
            int answer = -1;
            if(visited[end[0]][end[1]]){
                answer = 1;
            }else{
                answer = 0;
            }
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int[] start){
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.addLast(start);
        visited[start[0]][start[1]] = true;

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();
            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r < 0 || c < 0 || r>= 100 || c>= 100) continue;

                if(board[r][c] ==1 ) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[]{r, c});
                }
            }
        }
    }
}
