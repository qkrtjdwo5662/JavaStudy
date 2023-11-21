package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1216 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        while(true){
            st = new StringTokenizer(br.readLine());
            int tc = Integer.parseInt(st.nextToken());


            int answer = 0;
            char[][] board = new char[100][100];

            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                String s= st.nextToken();
                for (int j = 0; j < 100; j++) {
                    board[i][j] = s.charAt(j);
                }
            }

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    String s = "";

                    s = s + board[i][j];

                    if(j != 99){
                        for (int k = j+1; k <100 ; k++) { // 누적
                            s = s+board[i][k];

                            if (check(s)) {
                                answer = Math.max(answer, s.length());
                            }
                        }
                    }

                }
                for (int j = 0; j < 100; j++) {
                    String s = "";

                    s = s + board[j][i];

                    if(j != 99){
                        for (int k = j+1; k <100 ; k++) { // 누적
                            s = s+board[k][i];

                            if (check(s)) {
                                answer = Math.max(answer, s.length());
                            }
                        }
                    }

                }

            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
            if(tc == 10) break;
        }
        System.out.println(sb);
    }

    public static boolean check(String s){
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }

        return true;
    }

}
