import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class N_11050{
    static int dp [][] = new int[11][11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        System.out.println(Combination(n,r));

    }
    static int Combination(int n, int r){
        if(dp[n][r]>0){
            return dp[n][r];
        } else if (n==r || r==0) {
            return dp[n][r] = 1;
        }else {
            return dp[n][r] = Combination(n-1, r-1) + Combination(n-1,r);
        }
    }
}