import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N_24479 {
    public static boolean[] visited;
    public static ArrayList<Integer>[] adjList;
    public static int count;
    public static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList[start].add(end);
            adjList[end].add(start);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList[i]);
        }

        visited = new boolean[n+1];
        answer = new int[n+1];

        count = 1;
        dfs(r);

        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int now){
        if(visited[now]) return; // 이미 true면 탐색 x

        visited[now] = true; // 방문 체크 해주고
        answer[now] = count;
        count++;
        for (int i = 0; i < adjList[now].size(); i++) {
            dfs(adjList[now].get(i));
        }
    }
}
