package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1216 {
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = 10;

        for (int i = 1; i <= tc ; i++) {
            char[][] board = new char[100][100];
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 100 ; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int k = 0; k < 100; k++) {
                    board[j][k] = s.charAt(k);
                }
            }
            answer = 0;
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 100- j; k++) {
                    String s = "";
                    for (int l = k; l <= j+k; l++) {
                        s = s + board[j][l];
                    }
                    if(check(s)) answer = Math.max(answer, s.length());

                    s="";
                    for (int l = k; l <= j+k; l++) {
                        s = s + board[l][j];
                    }
                    if(check(s)) answer = Math.max(answer, s.length());
                }

            }



            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean check(String s){
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }

        return true;
    }

}
