package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1220 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb =  new StringBuilder();

        int tc = 10;

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int[][] board = new int[100][100];

            for (int j = 0; j < 100; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 100; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    board[j][k] = num;
                }
            }
            int now = 0;
            int answer = 0;
            for (int j = 0; j < 100; j++) {
                now = 0;
                for (int k = 0; k < 100; k++) {
                    if(board[k][j] == 1) now = 1;
                    else if(board[k][j] == 2){
                        if(now == 1) {
                            answer += 1;
                            now = 0;
                        }
                    }
                }
            }


            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
