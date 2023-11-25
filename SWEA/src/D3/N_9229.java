package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_9229 {
    public static boolean[] visited;
    public static int answer;
    public static int n;
    public static int[] snacks;
    public static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            snacks = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                snacks[j] = num;
            }
            visited = new boolean[n];
            answer = 0;
            dfs(0, 0);
            if(answer == 0 ) answer = -1;
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int depth, int sum){
        if(depth == 2){
            answer = Math.max(answer, sum);
            return;
        }


        for (int i = 0; i < n; i++) {
            if(!visited[i] && sum + snacks[i] <= m){

                visited[i] = true;

                dfs(depth+1, sum + snacks[i]);

                visited[i] = false;
            }
        }
    }
}
