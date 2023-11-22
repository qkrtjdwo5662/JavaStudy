package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_11315 {
    public static int[] ry = {1, -1, 0, 0, 1, 1, -1, -1};
    public static int[] rx = {0, 0, 1, -1, 1, -1, 1, -1};
    public static int n;
    public static int[][] board;
    public static boolean answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            board = new int[n][n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();

                for (int k = 0; k < s.length(); k++) {
                    if(s.charAt(k) == 'o'){
                        board[j][k] = 1;
                    }
                }

            }

            answer = false;

            loop:
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(answer) break loop;

                    if(board[j][k] == 1){ // 돌이 놓여있으면

                        for (int l = 0; l < 8; l++) {
                            int r = j + ry[l];
                            int c = k + rx[l];

                            if(r < 0 || c<0 || r>=n || c>=n) continue;

                            if(board[r][c] == 1){
                                check(new int[]{r, c}, 2, l);
                            }
                        }
                    }
                }
            }


            if(answer){
                sb.append("#").append(i).append(" ").append("YES").append("\n");
            }else sb.append("#").append(i).append(" ").append("NO").append("\n");
        }
        System.out.println(sb);
    }

    public static void check(int[] now, int count, int dir){
        if(count == 5){
            answer = true;
            return;
        }

        int[] next = {now[0] + ry[dir], now[1] + rx[dir]};

        if(next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= n) return; // 범위 벗어나면 끝

        if(board[next[0]][next[1]] == 1) check(next, count + 1, dir);
    }
}
