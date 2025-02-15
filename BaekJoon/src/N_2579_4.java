import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2579_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        if(n == 1) {
            System.out.println(arr[0]);
            return;
        }

        int[][] dp = new int[n][3];

        dp[0][1] = arr[0];
        dp[0][2] = 0;
        dp[1][1] = arr[1];
        dp[1][2] = arr[0] + arr[1];
        for (int i = 2; i < n; i++) {
            dp[i][1] = Math.max(dp[i - 2][1] + arr[i], dp[i - 2][2] + arr[i]);
            dp[i][2] = dp[i - 1][1] + arr[i];
        }
        int answer = Math.max(dp[n - 1][1], dp[n - 1][2]);
        sb.append(answer).append("\n");
        System.out.println(sb);
    }
}
