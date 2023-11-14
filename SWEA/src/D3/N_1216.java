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

            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 100; k++) {
                    String s = "";
                    for (int l = 0; l < 100-k; l++) {
                        s += board[j][k+l];
                    }
                }
            }
            
            answer = 0;
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void rowCheck(){
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {

            }
        }
    }

    public static void columnCheck(){

    }
}
