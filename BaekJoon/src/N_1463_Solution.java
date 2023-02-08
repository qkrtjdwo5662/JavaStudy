import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.min;

public class N_1463_Solution {
    public static void main(String[] args) throws IOException {
        final int MAX = 1_000_001;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[MAX];

        dp[0]=0;
        dp[1]=0;

        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i-1]+1;
            if(i%3==0) dp[i] = min(dp[i],dp[i/3]+1);
            if(i%2==0) dp[i] = min(dp[i],dp[i/2]+1);
        }
        System.out.println(dp[x]);


    }
}
