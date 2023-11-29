package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N_2819 {
    public static int[] ry = {0, 0, 1, -1};
    public static int[] rx = {1, -1, 0, 0};
    public static int[][] board;
    public static HashSet<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb= new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= tc ; i++) {
            board = new int[4][4];

            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    board[j][k] = num;
                }
            }
            set = new HashSet<>();
            for (int j = 0; j <4 ; j++) {
                for (int k = 0; k <4 ; k++) {
                    dfs(new int[]{j, k}, 1, String.valueOf(board[j][k]));
                }
            }

            sb.append("#").append(i).append(" ").append(set.size()).append("\n");

        }

        System.out.println(sb);
    }

    public static void dfs(int[] now, int depth, String s){
        if(depth == 7){
            set.add(s);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int r = now[0] + ry[i];
            int c = now[1] + rx[i];

            if(r <0 || c<0 || r>= 4 || c>= 4) continue;

            dfs(new int[]{r, c}, depth+1, s+board[r][c]);
        }

    }
}
