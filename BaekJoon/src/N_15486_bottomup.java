import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_15486_bottomup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        int[] dp = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        for (int i = 0; i < n; i++) {
            if(i + arr[i][0] <= n) dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], dp[i] + arr[i][1]);
            // 일을 할 수 있는 날이면 그전에 넘어갈 수 있는 최댓값을 넘김

            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
            // 그냥 단순하게 일을 안하고 그다음 날로 넘길 수 있음
        }

//        System.out.println(Arrays.toString(dp));
        sb.append(dp[n]).append("\n");
        System.out.println(sb);
    }
}
