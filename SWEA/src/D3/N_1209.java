package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1209 {
    public static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = 10;

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            board = new int[100][100];


            for (int j = 0; j < 100; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 100; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    board[j][k] = num;
                }
            }

            int answer = 0;
            answer = Math.max(Math.max(maxCol(), maxRow()), Math.max(maxCrossSecond(), maxCrossFirst()));

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static int maxRow(){
        int answer = 0;

        for (int i = 0; i < 100; i++) {
            int sum = 0;
            for (int j = 0; j < 100; j++) {
                sum += board[i][j];
            }

            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static int maxCol(){
        int answer = 0;

        for (int i = 0; i < 100; i++) {
            int sum = 0;
            for (int j = 0; j < 100; j++) {
                sum += board[j][i];
            }

            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static int maxCrossFirst(){
        int answer = 0;

        for (int i = 0; i < 100; i++) {
            answer += board[i][i];
        }

        return answer;
    }

    public static int maxCrossSecond(){
        int answer = 0;

        for (int i = 0; i < 100; i++) {
            answer += board[i][99-i];
        }

        return answer;
    }
}
