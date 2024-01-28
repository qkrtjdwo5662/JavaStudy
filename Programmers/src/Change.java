import java.util.Arrays;

public class Change {

    static int n = 5;
    static int[] money = {1,2,5};
    public static void main(String[] args) {
        System.out.println(solution(n, money));
    }

    static int solution(int n, int[] money) {

        // n 거슬러 줘야하는 목표 금액
        // money : 보유하고 있는 돈의 종류


        // 거슬러 줄수 있는 방법의 수?

        int[][] dp = new int[money.length + 1][ n + 1];

        for (int i = 1; i <= money.length ; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= money.length ; i++) {
            for (int j = 1; j <= n  ; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= money[i-1]){
                    dp[i][j] += dp[i][j-money[i-1]];
                    dp[i][j] %= 1_000_000_007;
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[money.length][n];
    }
}
