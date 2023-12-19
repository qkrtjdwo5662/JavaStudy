package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_1868_2 {
    public static int[] ry = {1, -1, 0, 0, 1, 1, -1, -1};
    public static int[] rx = {0, 0, 1, -1, 1, -1, 1, -1};
    public static int n;
    public static char[][] board;
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());


            board = new char[n][n];
            visited = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();

                for (int k = 0; k < s.length(); k++) {
                    char c = s.charAt(k);
                    board[j][k] = c;
                    if(c == '*'){ // 지뢰 방문처리
                        visited[j][k] = true;
                    }
                }
            }
            int answer =0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(!visited[j][k] && board[j][k] == '.' && checkMine(new int[]{j, k}) == 0){
                        bfs(new int[]{j, k});
                        answer++;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(!visited[j][k] && board[j][k] == '.'){
                        visited[j][k] = true;
                        answer++;
                    }
                }
            }

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int[] start){
        visited[start[0]][start[1]] = true;

        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.addLast(start);
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();
            for (int i = 0; i < 8; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r < 0 || c< 0 || r>= n || c>= n) continue;

                if(board[r][c] == '*') continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    if(checkMine(new int[]{r, c}) == 0){
                        deque.addLast(new int[]{r, c});
                    }
                }
            }
        }
    }

    public static int checkMine(int[] now){
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int r = now[0] + ry[i];
            int c = now[1] + rx[i];

            if(r < 0 || c< 0 || r>= n || c>= n) continue;

            if(board[r][c] == '*') count++;
        }

        return count;
    }
}
