package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1468 {
    public static int n;
    public static int b;
    public static int[] heights;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken()); // 점원의 수
            b = Integer.parseInt(st.nextToken()); // 목표 높이

            heights = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int height = Integer.parseInt(st.nextToken());
                heights[j] = height;
            }

            answer = Integer.MAX_VALUE;
            dfs(0, 0);
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int index, int sum){
        if(index == n){
            if(sum >= b){
                answer = Math.min(answer, sum- b);
            }
            return;
        }

        dfs(index + 1, sum);
        dfs(index + 1, sum + heights[index]);
    }
}

// 부분집합의 합은 backtracking 보다 dfs로 풀 것
