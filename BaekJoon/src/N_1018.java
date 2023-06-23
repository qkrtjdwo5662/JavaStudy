import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board_m = new char[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                board_m[i][j] = s.charAt(j);
            }
        }

        // (0,0) -> W or B
        int answer = 0;
        int count_w = Integer.MAX_VALUE;
        int count_b = Integer.MAX_VALUE;

        //1. w
        for (int i = 0; i <n-8+1 ; i++) {
            for (int j = 0; j < m-8+1; j++) {
                char[][] board = new char[8][8];
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        board[k][l] = board_m[i+k][j+l];
                    }
                }
                int count = 0;

                for (int k = 0; k < 8; k++) {
                    if(k%2==0){ // 짝수 행
                        if(board[k][0] == 'W') continue; // 이미 W
                        else board[k][0] = 'W'; count ++;
                    }else {// 홀수 행
                        if(board[k][0] =='B') continue; // 이미 B
                        else board[k][0] = 'B'; count++;
                    }


                }
                for (int k = 0; k < 8; k++) {
                    for (int l = 1; l < 8; l++) {
                        if(board[k][l-1] == 'W'){
                            if(board[k][l] == 'B') continue; // 이미 W
                            else board[k][l] = 'B'; count ++;
                        }else{
                            if(board[k][l] == 'W') continue; // 이미 W
                            else board[k][l] = 'W'; count ++;
                        }
                    }
                }
                count_w = Math.min(count_w, count);
            }
        }

        //2. b
        for (int i = 0; i <n-8+1 ; i++) {
            for (int j = 0; j < m-8+1; j++) {
                char[][] board = new char[8][8];
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        board[k][l] = board_m[i+k][j+l];
                    }
                }
                int count = 0;

                for (int k = 0; k < 8; k++) {
                    if(k%2==0){ // 짝수 행
                        if(board[k][0] == 'B') continue; // 이미 W
                        else board[k][0] = 'B'; count ++;
                    }else {// 홀수 행
                        if(board[k][0] =='W') continue; // 이미 B
                        else board[k][0] = 'W'; count++;
                    }


                }
                for (int k = 0; k < 8; k++) {
                    for (int l = 1; l < 8; l++) {
                        if(board[k][l-1] == 'W'){
                            if(board[k][l] == 'B') continue; // 이미 W
                            else board[k][l] = 'B'; count ++;
                        }else{
                            if(board[k][l] == 'W') continue; // 이미 W
                            else board[k][l] = 'W'; count ++;
                        }
                    }
                }
                count_b = Math.min(count_b, count);
            }
        }
        answer = Math.min(count_b, count_w);
        System.out.println(answer);
    }
}
