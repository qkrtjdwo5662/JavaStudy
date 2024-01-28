package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_5215_3 {
    static class Food{
        int score;
        int calorie;

        public Food(int score, int calorie){
            this.score = score;
            this.calorie = calorie;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb=  new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 재료의 수
            int l = Integer.parseInt(st.nextToken()); // 제한 칼로리

            Food[] foods = new Food[n +1];
            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());

                int score = Integer.parseInt(st.nextToken());
                int calorie = Integer.parseInt(st.nextToken());

                foods[j] = new Food(score, calorie);
            }

            int[][] dp = new int[n + 1][l + 1];
            // i개의 재료를 담았을 때
            // j칼로리 일때의 최대 점수

            for (int j = 1; j <= n ; j++) {
                Food food = foods[j];
                for (int k = 1; k <= l ; k++) {
                    dp[j][k] = dp[j-1][k];

                    if(k >= food.calorie){
                        dp[j][k] = Math.max(dp[j][k], dp[j-1][k-food.calorie] + food.score);
                    }
                }
            }
            sb.append("#").append(i).append(" ").append(dp[n][l]).append("\n");

        }
        System.out.println(sb);
    }
}
