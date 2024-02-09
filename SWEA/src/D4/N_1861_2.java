package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N_1861_2 {
    static int n;
    static int[][] board;
    static int maxCount;
    static int minNum;
    static ArrayList<Integer> list;

    static int[] ry = {1, 0, -1, 0};
    static int[] rx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            board = new int[n][n];
            maxCount = 0;
            minNum = 1_000_000;
            list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    board[j][k] = num;
                }
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dfs(new int[]{j, k}, 1, board[j][k]);
                }
            }
            sb.append("#").append(i).append(" ");
            sb.append(minNum).append(" ").append(maxCount).append("\n");

        }
        System.out.println(sb);



    }

    static void dfs(int[] now, int count, int start){
        if(maxCount < count){
            maxCount = count;
            minNum = start;
        }else if(maxCount == count && minNum > start) {
            minNum = start;
        }



        for (int i = 0; i < 4; i++) {
            int r = now[0] + ry[i];
            int c = now[1] + rx[i];

            if(r < 0 || c<0 || r>= n || c>= n) continue;

            if(board[r][c] == board[now[0]][now[1]] + 1){
                dfs(new int[]{r, c}, count+1, start);
            }
        }

    }
}
