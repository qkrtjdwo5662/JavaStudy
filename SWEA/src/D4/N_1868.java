package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_1868 {
    public static int[] ry = {1, -1, 0, 0, 1, 1, -1, -1};
    public static int[] rx = {0, 0, 1, -1, 1, -1, 1, -1};
    public static int n;
    public static char[][] board;
    public static boolean[][] visited;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            board = new char[n][n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int k = 0; k < s.length(); k++) {
                    char c = s.charAt(k);
                    board[j][k] = c;

                }
            }
            // 각 칸에는 대각선, 상하좌우 8칸에 몇개의 지뢰가 있는지 표시됨
            // 숫자가 0이면 나머지 8칸의 숫자도 표시됨
            // 지뢰 *
            // 지뢰 없는 칸 .
            // 지뢰가 없는 칸을 제외한 모든 칸이 숫자가 표시되려면 최소 몇번의 클릭?

            visited = new boolean[n][n]; // 방문 체크 용
            answer = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(!visited[j][k] && mineCheck(new int[]{j, k}) == 0 && board[j][k] != '*'){ // 지뢰 아닌 곳 클릭 시작
                        bfs(new int[]{j, k});
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(!visited[j][k] && board[j][k] != '*'){ // 지뢰 아닌 곳 클릭 시작
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

                if(r < 0 || c<0 || r>= n || c>= n) continue;

                if(board[r][c] == '*') continue; // 지뢰면 continue

                if(!visited[r][c]){
                    visited[r][c] = true;

                    if(mineCheck(new int[]{r, c}) == 0){
                        deque.addLast(new int[]{r,c});
                    }
                }
            }
        }

        answer++;
    }

    public static int mineCheck(int[] now){
        int answer = 0;

        for (int i = 0; i < 8; i++) {
            int r = now[0] + ry[i];
            int c = now[1] + rx[i];

            if(r < 0 || c < 0 || r>= n || c>= n) continue;

            if(board[r][c] == '*') answer++;
        }


        return answer;
    }
}
