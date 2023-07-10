import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_11724_dfs {
    public static boolean[] visited;
    public static ArrayList<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        adjList = new ArrayList[n+1]; // 1 ~ n
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int now){
        if(visited[now]) return;

        visited[now] = true;
        for (int i = 0; i <adjList[now].size(); i++) {
            dfs(adjList[now].get(i));
        }
    }
}
