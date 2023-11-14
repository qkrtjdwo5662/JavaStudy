package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_2814 {
    public static ArrayList<Integer>[] adjList;
    public static boolean[] visited;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            adjList = new ArrayList[n+1];

            for (int j = 1; j <= n ; j++) {
                adjList[j] = new ArrayList<>();
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                adjList[u].add(v);
                adjList[v].add(u);
            }
            answer = 0;
            for (int j = 1; j <= n; j++) {
                visited = new boolean[n+1];
                visited[j] = true;
                dfs(j, 1);
            }


            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);

    }
    public static void dfs(int now, int count){
        System.out.println(now + " " + count);
        answer = Math.max(answer, count);

        for (int i = 0; i < adjList[now].size(); i++) {
            int next = adjList[now].get(i);

            if(!visited[next]){
                visited[next] = true;
                dfs(next, count+1);
                visited[next] = false;
            }
        }

    }
}
