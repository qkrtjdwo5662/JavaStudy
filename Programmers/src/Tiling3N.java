public class Tiling3N {
    public static int n = 6;
    public static void main(String[] args) {
        System.out.println(solution(n));
    }

    public static int solution(int n){
        int[] dp = new int[n+1];

        dp[2] = 3;
        dp[4] = 11;
        for (int i = 6; i < n+1; i++) {
            if(i%2 == 0) {
                dp[i] = ((3 * dp[i - 2]) +2) % 1000000007;
            }
        }

        return dp[n];
    }
}
