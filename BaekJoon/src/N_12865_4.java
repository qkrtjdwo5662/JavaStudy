import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_12865_4 {
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

        int n = Integer.parseInt(st.nextToken()); // 물품 수
        int k = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

        Goods[] goods = new Goods[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            goods[i] = new Goods(w, v);
        }

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            Goods now = goods[i - 1]; // 현재 물품

            for (int j = 1; j <= k ; j++) {
                dp[i][j] = dp[i - 1][j]; // 그전꺼 넣어줘

                if(j >= now.weight){ // 해당 무게였을때 해당 가치를 얻을 수 있으니까
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-now.weight] + now.value);
                }
            }
        }

        sb.append(dp[n][k]).append("\n");
        System.out.println(sb);

    }
}
