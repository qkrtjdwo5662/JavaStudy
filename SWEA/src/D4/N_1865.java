package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1865 {
    public static int n;
    public static int[][] arr;
    public static boolean[] visited;
    public static double answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            arr = new int[n][n];

            for (int j = 0; j < n; j++) {
                st =  new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[j][k] = num;
                }
            }
            visited = new boolean[n];
            answer = 0;
            backtrack(0, 1);
            sb.append("#").append(i).append(" ").append(String.format("%.6f",(answer))).append("\n");
        }
        System.out.println(sb);
    }

    public static void backtrack(int depth, double multi){
        if(multi * 100 <= answer){
            return;
        }
        // 한번 answer보다 낮게 되면 무엇을 곱해도 결과는 answer보다 낮음

        if(depth == n){
            if(multi*100 > answer){
                answer = multi*100;
            }
            return;
        }


        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                backtrack(depth+1, multi * arr[depth][i]/100);
                visited[i] = false;
            }
        }
    }
}
