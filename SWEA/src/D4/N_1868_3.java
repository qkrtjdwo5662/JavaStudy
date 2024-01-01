package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_1868_3 {
    public static int n;
    public static int[] ry = {1, -1, 0, 0, 1, 1, -1, -1};
    public static int[] rx = {0, 0, 1, -1, 1, -1, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            
            char[][] board = new char[n][n];
            boolean[][] visited = new boolean[n][n];
            ArrayList<int[]> bombList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int k = 0; k < s.length(); k++) {
                    board[j][k] = s.charAt(k);
                    if(s.charAt(k) == '*') {
                        bombList.add(new int[]{j,k});
                        visited[j][k] = true;
                    }
                }
            }
            int answer =0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(!visited[j][k] && zeroCheck(new int[]{j, k}, board)){
                        bfs(new int[]{j, k}, board, visited);
                        answer++;
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(!visited[j][k]){
                        answer++;
                    }
                }
            }

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    static void bfs(int[] start, char[][] board, boolean[][] visited){
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        visited[start[0]][start[1]] = true;
        deque.addLast(start);

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 8; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r < 0 || c< 0 || r>= n || c>= n) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    if(zeroCheck(new int[]{r, c}, board)){
                        deque.addLast(new int[]{r, c});
                    }
                }
            }
        }
    }
    static boolean zeroCheck(int[] now, char[][] board){
        for (int i = 0; i < 8 ; i++) {
            int r = now[0] + ry[i];
            int c = now[1] + rx[i];

            if(r < 0 || c< 0 || r>= n || c>= n) continue;

            if(board[r][c] == '*') return false;
        }

        return true;
    }
}
