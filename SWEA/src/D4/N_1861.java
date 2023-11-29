package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N_1861 {
    public static int[] ry ={1, -1, 0, 0};
    public static int[] rx ={0, 0, 1, -1};
    public static int[][] board;
    public static boolean[][] visited;
    public static int n;
    public static int maxCount;
    public static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());

            board = new int[n][n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    board[j][k] = num;
                }
            }

            visited= new boolean[n][n];
            maxCount = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    visited[j][k] = true;
                    dfs(1, new int[]{j, k}, board[j][k], 1);
                    visited[j][k] = false;
                }
            }

            list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    visited[j][k] = true;
                    dfs(1, new int[]{j, k}, board[j][k], 2);
                    visited[j][k] = false;
                }
            }

            Collections.sort(list);
            sb.append("#").append(i).append(" ").append(list.get(0)).append(" ").append(maxCount).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int count, int[] now, int start, int opr){
        if(opr == 1) maxCount = Math.max(maxCount, count);
        else if(opr == 2) if(count == maxCount) list.add(start);

        for (int i = 0; i < 4; i++) {
            int r = now[0] + ry[i];
            int c = now[1] + rx[i];

            if(r < 0 || c<0 || r>= n || c>= n) continue;


            if(board[now[0]][now[1]] +1 !=  board[r][c]) continue;

            if(!visited[r][c]){
                visited[r][c] = true;
                dfs(count+1, new int[]{r, c}, start, opr);
                visited[r][c] = false;
            }
        }



    }
}
