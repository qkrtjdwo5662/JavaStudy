package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_4615 {
    public static int[] ry = {1, -1, 0, 0, 1, 1, -1, -1};
    public static int[] rx = {0, 0, 1, -1, 1, -1, 1, -1};
    public static int n;
    public static int m;
    public static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            board = new int[n][n];

            int middle = n/2;
            board[middle][middle] = 2;
            board[middle-1][middle-1] = 2;
            board[middle-1][middle] = 1;
            board[middle][middle-1] = 1;
            // 초기 데이터

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int color = Integer.parseInt(st.nextToken());

                 x = x-1;
                 y = y-1;

                board[y][x] = color; // 배치하면 흰돌 있는 방향 찾아서 바꿔주기

                for (int k = 0; k < 8; k++) {
                    int r = y + ry[k];
                    int c = x + rx[k];

                    if(r < 0 || c< 0 || r>=n || c >= n) continue; // 범위 벗어남

                    if(board[r][c] == 0 || board[r][c] == color) continue; // 색이 없거나 같은 색 돌


                    change(new int[]{y, x}, new int[]{r, c}, k, color); // 색 다르면 change 시작

                }

            }

            int black = 0;
            int white = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(board[j][k] == 1){
                        black ++;
                    }else if(board[j][k] == 2){
                        white ++;
                    }
                }
            }


            sb.append("#").append(i).append(" ").append(black).append(" ").append(white).append("\n");
        }
        System.out.println(sb);
    }

    public static void change(int[] start, int[] pos, int direction, int color){
        int other = -1;
        if(color == 1) other = 2;
        else if(color == 2) other = 1;

        if(pos[0] + ry[direction] < 0 || pos[0] + ry[direction] >= n || pos[1] + rx[direction] < 0 ||pos[1] + rx[direction]>= n){ // 끝에 다다르면
            if(board[pos[0]][pos[1]] == other){ // color 확인하고
                back(start, pos ,direction, other );
            }
            return;
        }

        board[pos[0]][pos[1]] = color; // 색 변경

        int[] next = {pos[0] + ry[direction], pos[1] + rx[direction]};
        // 포지션 방향만큼 1 움직이고,

        if(next[0] <0 || next[0] >= n || next[1] <0 || next[1] >= n) return; // 범위 넘어가면 return

        if(board[next[0]][next[1]] == 0){ //0이면 back
            back(start, pos, direction, other);
        }else if(board[next[0]][next[1]] != color){ // 색 다르면 계속 change
            change(start, next, direction, color);
        }

    }
    public static void back(int[] start, int[] pos, int direction, int color){
        if(pos[0] == start[0] && pos[1] == start[1]){ // back point에 다다르면

            return; // 종료
        }

        board[pos[0]][pos[1]] = color;
        int[] next = {pos[0] - ry[direction], pos[1] - rx[direction]};


        back(start, next, direction, color);
    }
}
