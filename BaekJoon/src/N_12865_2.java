import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_12865_2 {
    static class Goods{
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

        int n = Integer.parseInt(st.nextToken()); // 물건의 개수
        int k = Integer.parseInt(st.nextToken()); // 담을 수 있는 최대 무게

        Goods[] goods = new Goods[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            goods[i] = new Goods(w, v);
        }

        int[][] dp = new int[n + 1][k + 1];
        // i번쨰 물건을 포함 하여
        // j무게 만큼 담았을 때 최대값

        for (int i = 1; i <= n ; i++) {
            Goods good = goods[i];
            for (int j = 1; j <= k ; j++) {
                dp[i][j] = dp[i-1][j]; // 그전꺼 우선 복사

                if(j >= good.weight){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-good.weight] + good.value);
                }
            }
        }

        System.out.println(dp[n][k]);


    }
}
