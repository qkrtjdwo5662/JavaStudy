package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_4615 {
    public static int[] ry = {1, -1, 0, 0, 1, 1, -1, -1};
    public static int[] rx = {0, 0, 1, -1, 1, -1, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] board = new int[n][n];

            // 1 흑돌
            // 2 백돌

            // 초기세팅
            int middle = n/2;
            board[middle][middle] = 2;
            board[middle-1][middle-1] = 2;
            board[middle-1][middle] = 1;
            board[middle][middle-1] = 1;

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int color = Integer.parseInt(st.nextToken());

                y = y-1;
                x = x-1;
                if(board[y][x] == 0){
                    board[y][x] = color;
                }else continue;


                System.out.println(Arrays.deepToString(board));
                for (int k = 0; k < 8; k++) {
                    int r = y + ry[k];
                    int c = x + rx[k];

                    if(r <0 || c<0 || r>= n || c>= n) continue; // 범위 벗어남

                    if(board[r][c] == 0 || board[r][c] == board[y][x]) continue; // 같거나 색이 없을 때

                    int rr = r + ry[k];
                    int cc = c + rx[k];
                    // 한칸 더 이동

                    if(rr <0 || cc<0 || rr>= n || cc>= n) continue; // 범위 벗어남

                    if(board[rr][cc] == board[y][x]){ // 초기돌과 색이 같다면
                        board[r][c] = board[y][x]; // 낑긴돌 색바꾸기
                    }


                }

                System.out.println(Arrays.deepToString(board));
                System.out.println();
            }
            int white = 0;
            int black = 0;


            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(board[j][k] == 1) black++;
                    else if(board[j][k] == 2) white ++;
                }
            }



            sb.append("#").append(i).append(" ").append(black).append(" ").append(white).append("\n");
        }
        System.out.println(sb);


    }
}
