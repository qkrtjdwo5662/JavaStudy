public class Fibo {
    public static int n =5;
    public static void main(String[] args) {
        System.out.println(solution(n));
    }

    public static int solution(int n){
        int[] dp = new int[100_000 + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= 100_000 ; i++) {
            dp[i] = (dp[i-2]%12345667 + dp[i-1]%12345667) % 1234567;
        }

        return dp[n]%1234567;

    }
}
