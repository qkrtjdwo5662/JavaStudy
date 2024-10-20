import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_12865_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][2];

        for (int i = 1; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j <= k ; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j >= arr[i][0]){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - arr[i][0]] + arr[i][1]);
                }
            }
        }
        sb.append(dp[n][k]).append("\n");
        System.out.println(sb);
    }
}
