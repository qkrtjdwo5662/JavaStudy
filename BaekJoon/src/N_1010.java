import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1010 {
    static int dp[][] = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
             st = new StringTokenizer(br.readLine());
             int left = Integer.parseInt(st.nextToken());
             int right = Integer.parseInt(st.nextToken());
             System.out.println(combination(right,left));
        }
    }
    static int combination(int n, int r){
        if(dp[n][r]>0){
            return dp[n][r];
        } else if (n==r || r==0) {
            return dp[n][r]=1;
        }else{
            return dp[n][r] = combination(n-1,r-1) + combination(n-1,r);
        }
    }
}
