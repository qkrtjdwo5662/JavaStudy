import java.util.Arrays;

class DP_test2{
	private static long[] dp = new long[101];
	
	public static void main(String[] args) {
		System.out.println(fibo(20));
		System.out.println(Arrays.toString(dp));
	}
	
	public static long fibo(int n) {
		if(dp[n]>0) {
			return dp[n];
		}
		if(n<=2) {
			return dp[n]=1;
		}
		return dp[n] = fibo(n-2) + fibo(n-1);
	}
}