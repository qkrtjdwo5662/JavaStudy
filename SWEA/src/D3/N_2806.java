package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2806 {
    public static int n;
    public static int answer;
    public static int[]board;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            board = new int[n]; // board
            visited = new boolean[n];
            answer = 0;
            dfs(0);
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int depth){
        if(depth == n){
            answer += 1;
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean check = false;
            for (int j = 0; j < depth; j++) {
                if(board[j] == i || Math.abs(j - depth) == Math.abs(board[j] - i)){
                    check = true;
                    break;
                }
            }
            if(check) continue;
            board[depth] = i;
            dfs(depth+1);
        }
    }
}
