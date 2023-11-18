package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_3282 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(st.nextToken()); // 물건 개수
            int k = Integer.parseInt(st.nextToken()); // 가방 부피 

            int[][] dp = new int[n+1][k+1];

            int answer = 0;

            int[] v = new int[n+1];
            int[] c = new int[n+1];

            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                v[j] = Integer.parseInt(st.nextToken());
                c[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n ; j++) {
                for (int l = 1; l <= k ; l++) {
                    if(v[j] > l){
                        dp[j][l] = dp[j-1][l];
                    }else{
                        dp[j][l] = Math.max(dp[j-1][l-v[j]] + c[j],dp[j-1][l] );
                    }
                }
            }
            System.out.println(Arrays.deepToString(dp));
            for (int j = 1; j <= k ; j++) {
                answer = Math.max(answer, dp[n][j]);
            }
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
