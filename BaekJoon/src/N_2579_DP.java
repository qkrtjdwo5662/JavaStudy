import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_2579_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int[] stairs = new int[n + 1];
        for (int i = 1; i <=  n; i++) {
            st = new StringTokenizer(br.readLine());
            int stair = Integer.parseInt(st.nextToken());
            stairs[i] = stair;
        }

        if(n == 1){
            System.out.println(stairs[1]);
            return;
        }else if(n == 2){
            System.out.println(stairs[1] + stairs[2]);
            return;
        }

        int[][] dp = new int[n + 1][2];
        // i번쨰 계단을 갔을때
        // 최대 점수 값

        dp[1][0] = stairs[1]; // 첫번째 계단
        dp[1][1] = 0; //

        dp[2][0] = stairs[2];
        dp[2][1] = dp[1][0] + stairs[2];

        for (int i = 3; i <= n ; i++) {
            dp[i][0] = Math.max(dp[i-2][0] + stairs[i], dp[i-2][1] + stairs[i]);
            dp[i][1] = dp[i-1][0] + stairs[i]; // 그전 계단 값

        }

        int answer = Math.max(dp[n][0], dp[n][1]);
        System.out.println(answer);
    }
}
