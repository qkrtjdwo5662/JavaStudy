import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_12865 {
    private static class Goods{
        int weight;
        int value;

        public Goods(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Goods[] goods = new Goods[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            goods[i] = new Goods(weight, value);
        }

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n ; i++) {
            Goods now = goods[i];
            for (int j = 1; j <= k ; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= now.weight){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-now.weight] + now.value);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[n][k]);
    }
}
