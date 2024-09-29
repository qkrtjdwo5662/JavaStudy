import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_12865_3 {
    static class Goods{
        int w;
        int v;

        public Goods(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
    static Goods[] goodsArr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 물품의 수
        int k = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

        goodsArr = new Goods[n];
        dp = new int[n + 1][k + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            Goods goods = new Goods(w, v);
            goodsArr[i] = goods;
        }

        for (int i = 1; i <= n ; i++) {
            Goods now = goodsArr[i - 1];

//            dp[i][now.w] = now.v;
            for (int j = 0; j <= k ; j++) {
                dp[i][j] = dp[i-1][j];

                if(j >= now.w){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-now.w] + now.v);
                }
            }

        }
//        System.out.println(Arrays.deepToString(dp));
        sb.append(dp[n][k]);
        System.out.println(sb);

    }
}
