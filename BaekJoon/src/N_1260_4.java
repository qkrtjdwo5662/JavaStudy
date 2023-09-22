import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N_1260_4 {
    public static boolean[] visited;
    public static ArrayList<Integer>[] adjList;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        adjList= new ArrayList[n+1];
        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }
        for (int i = 1; i <= n ; i++) {
            Collections.sort(adjList[i]);
        }


        visited = new boolean[n+1];

        dfs(start);
        sb.append("\n");
        visited = new boolean[n+1];
        bfs(start);

        System.out.println(sb);
    }
    public static void bfs(int start){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        visited[start] = true;
        deque.addLast(start);
        sb.append(start).append(" ");

        while(!deque.isEmpty()){
            int now = deque.pollFirst();

            for (int i = 0; i < adjList[now].size(); i++) {
                if(!visited[adjList[now].get(i)]){
                    visited[adjList[now].get(i)] = true;
                    deque.addLast(adjList[now].get(i));
                    sb.append(adjList[now].get(i)).append(" ");
                }
            }
        }

    }

    public static void dfs(int now){
        if(visited[now]) return;
        visited[now] = true;
        sb.append(now).append(" ");

        for (int i = 0; i < adjList[now].size(); i++) {
            dfs(adjList[now].get(i));
        }
    }
}
