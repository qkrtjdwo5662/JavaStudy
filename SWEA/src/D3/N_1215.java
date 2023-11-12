package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1215 {
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = 10;

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            int len = Integer.parseInt(st.nextToken());
            char[][] board = new char[8][8];
            answer = 0;

            for (int j = 0; j < 8; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int k = 0; k < 8; k++) {
                    board[j][k] = s.charAt(k);
                }
            }


            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8 - len+1; k++) {
                    String s = "";
                    for (int l = k; l < k+len; l++) {
                        s = s+board[j][l];
                    }
                    palindrome(s);
                }
            }

            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8 - len+1; k++) {
                    String s = "";
                    for (int l = k; l < k+len; l++) {
                        s = s+board[l][j];
                    }
                    palindrome(s);
                }
            }


            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void palindrome(String s){
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return;
            }
        }

        answer += 1;
    }
}
