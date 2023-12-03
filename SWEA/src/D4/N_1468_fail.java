package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1468_fail {
//    public static int n;
//    public static int b;
//    public static boolean[] visited;
    public static int answer;
//    public static int[] heights;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 점원의 수
            int b = Integer.parseInt(st.nextToken()); // 목표 높이

            int[] heights = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int height = Integer.parseInt(st.nextToken());
                heights[j] = height;
            }

            boolean[] visited = new boolean[n];
            answer = Integer.MAX_VALUE;
            backtrack(0, 0, heights, visited, n, b);
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void backtrack(int depth, int sum, int[] heights, boolean[] visited, int n, int b){
        if(answer == 0) return; // 이미 최솟값에 도달했다면

        if(depth == n || sum >= b){ // 모든 조합 나왔고, sum이 목표 값보다 크다면 종료
            if(sum >= b){
                answer = Math.min(sum - b, answer);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                backtrack(depth+1, sum + heights[i], heights, visited, n, b);
                visited[i] = false;
            }

        }
    }
}
