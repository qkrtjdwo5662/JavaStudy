package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1979 {
    public static int[][] board;
    public static int n;
    public static int k;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            board = new int[n][n];

            for (int j = 0; j < n ; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < n; l++) {
                    int num = Integer.parseInt(st.nextToken());

                    board[j][l] = num;
                }
            }
            answer = 0;
            widthCount();
            heightCount();
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void widthCount(){
        int[][] check = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-k + 1; j++) {
                if(board[i][j] == 1){
                    int idx = j+1;
                    int count = 1;
                    while(idx < n){
                        if(board[i][idx] == 1){
                            count++;
                        }else break;
                        idx ++;
                    }
                    check[i][j] = count;
                    if(check[i][j] == k) {
                        if(j > 0 ){
                            if(check[i][j-1] == 0) answer++;
                        }else answer++;
                    }
                }
            }
        }
    }

    public static void heightCount(){
        int[][] check = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-k + 1; j++) {
                if(board[j][i] == 1){
                    int idx = j+1;
                    int count = 1;
                    while(idx < n){
                        if(board[idx][i] == 1){
                            count++;
                        }else break;
                        idx ++;
                    }
                    check[j][i] = count;
                    if(check[j][i] == k) {
                        if(j > 0 ){
                            if(check[j-1][i] == 0) answer++;
                        }else answer++;
                    }
                }
            }
        }
    }
}
