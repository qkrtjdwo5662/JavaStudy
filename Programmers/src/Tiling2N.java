public class Tiling2N {
    public static int n = 7;
    public static void main(String[] args) {
        System.out.println(solution(n));
    }

    public static int solution(int n){
        int[] dp = new int[n+1]; // memoization

        // 초기화
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;

        // 점화식
        for (int i = 5; i < n+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2])% 1000000007;
        }

        return dp[n];
    }
}
