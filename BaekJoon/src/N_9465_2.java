import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_9465_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[][] arr = new int[2][n];
            int[][] dp = new int[2][n + 1];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[i][j] = num;
                }
            }

            dp[0][1] = arr[0][0];
            dp[1][1] = arr[1][0];

            for (int i = 2; i <= n; i++) {
                int twoBeforeMax = Math.max(dp[0][i - 2], dp[1][i - 2]);

                dp[0][i] = Math.max(twoBeforeMax, dp[1][i - 1]) + arr[0][i - 1];
                dp[1][i] = Math.max(twoBeforeMax, dp[0][i - 1]) + arr[1][i - 1];
            }

            int answer = Math.max(dp[0][n], dp[1][n]);

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
