package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_4193_fail {
    public static int n;
    public static int[][] board;
    public static boolean[][] visited;
    public static ArrayDeque<int[]> deque;
    public static int[] ry = {1, -1, 0, 0};
    public static int[] rx = {0, 0, 1, -1};
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            board = new int[n][n];
            visited = new boolean[n][n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    board[j][k] = num;
                }
            }
            st = new StringTokenizer(br.readLine());
            int[] start = new int[2]; // 시작점
            for (int j = 0; j < 2; j++) {
                start[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int[] end = new int[2]; // 목표지점
            for (int j = 0; j < 2; j++) {
                end[j] = Integer.parseInt(st.nextToken());
            }
            answer = Integer.MAX_VALUE;
            // start -> end
            // 0 : 길, 1 : 장애물, 2 : 소용돌이
            // 소용돌이 2초 주기로 사라짐
            // 0, 1 -> O // 2 -> X // 3, 4 -> O // 5-> X // 6, 7 -> O // 8 -> X  : n%3 == 2 -> 소용돌이 사라짐

            if(start[0] == end[0] && start[1] == end[1]) {
                sb.append("#").append(i).append(" ").append(0).append("\n");
                continue;
            }
            visited[start[0]][start[1]] = true;
            dfs(start, end, 0);
            if(answer != 0){
                sb.append("#").append(i).append(" ").append(answer).append("\n");
            }else{
                sb.append("#").append(i).append(" ").append(-1).append("\n");
            }

        }
        System.out.println(sb);
    }
    static void dfs(int[] now, int[] end, int count){
        if(count > answer) return;

        if(now[0] == end[0] && now[1] == end[1]){
            // 도달하면 종료
            answer = count;
            return;
        }

//        System.out.println(now[0] + " " + now[1] + " " + count);
        for (int i = 0; i < 4; i++) {
            int r = now[0] + ry[i];
            int c = now[1] + rx[i];

            if(r < 0 || c < 0 || r>= n || c>= n) continue;

            if(board[r][c] == 1) continue;

            if(!visited[r][c]){
                if(board[r][c] == 0){
                    visited[r][c] = true;
                    dfs(new int[]{r,c}, end, count +1);
                    visited[r][c] = false;
                }else if(board[r][c] == 2){
                    if (count % 3 != 2) {
                        while (count % 3 != 2) {
                            count++;
                        }
                    }
                    visited[r][c] = true;
                    dfs(new int[]{r, c}, end, count + 1 );
                    visited[r][c] = false;

                }
            }


        }

    }
}
