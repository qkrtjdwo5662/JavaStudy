package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_5215 {
    public static int[][] arr;
    public static int answer;
    public static int n;
    public static int l;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 조합 수
            l = Integer.parseInt(st.nextToken()); // 제한 칼로리
            
            arr = new int[n][2];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int kal = Integer.parseInt(st.nextToken());

                arr[j][0] = score;
                arr[j][1] = kal;
            }
            answer = 0;
            dfs(0, 0, 0);
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int nowScore, int nowKal, int count){
        if(nowKal > l) return;
        else answer = Math.max(answer, nowScore);

        if(count == n) return;

        dfs(nowScore + arr[count][0], nowKal + arr[count][1], count + 1);
        dfs(nowScore, nowKal, count + 1);

    }
}
