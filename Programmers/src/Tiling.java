public class Tiling {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }
    public static int solution(int n){
        int [] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i]= dp[i-1] + dp[i-2];
            dp[i] = dp[i] % 1_000_000_007;
        }
        return dp[n];
    }
}
