package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_5215_2 {
    public static int answer;
    public static int[] scores;
    public static int[] calories;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 재료 수
            int l = Integer.parseInt(st.nextToken()); // 칼로리 제한

            scores = new int[n];
            calories = new int[n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                scores[j] = s;
                calories[j] = c;
            }

            answer = 0;
            dfs(0, 0, 0, n, l);
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int nowScore, int nowCal, int index, int n, int limit){
        if(nowCal > limit){
            return;
        }else if(index == n){
            answer = Math.max(answer, nowScore);
            return;
        }else{
            answer = Math.max(answer, nowScore);
        }



        dfs(nowScore + scores[index], nowCal + calories[index], index + 1, n, limit);
        dfs(nowScore , nowCal, index + 1, n, limit);
    }
}
