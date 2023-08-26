import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_2644 {
    public static ArrayList<Integer>[] adjList;
    public static boolean[] visited;
    public static int count;
    public static int end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }


        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }

        visited = new boolean[n+1];
        count = 0;
        dfs(start, 0);
        if(count == 0 ) System.out.println(-1);
        else System.out.println(count);
    }

    public static void dfs(int now, int depth){
        if(visited[now]) return;
        visited[now] = true;

        if(now == end) {
            count = depth;
            return;
        }

        for (int i = 0; i < adjList[now].size(); i++) {
            dfs(adjList[now].get(i), depth+1);
        }
    }
}
