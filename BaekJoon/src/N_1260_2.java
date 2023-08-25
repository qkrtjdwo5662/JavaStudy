import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N_1260_2 {
    public static StringBuilder sb = new StringBuilder();
    public static int n;
    public static int m;
//    public static int start;
    public static ArrayList<Integer>[] adjList;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n+1];

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

        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList[i]);
        }

        visited = new boolean[n+1];
        dfs(start);
        sb.append("\n");
        bfs(start);

        System.out.print(sb);
    }

    public static void bfs(int start){
        visited = new boolean[n+1];
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        visited[start] = true;
        arrayDeque.addLast(start);
        sb.append(start+" ");

        while(!arrayDeque.isEmpty()){
            int now = arrayDeque.pollFirst();

            for(int i=0; i<adjList[now].size(); i++){
                if(!visited[adjList[now].get(i)]){
                    visited[adjList[now].get(i)] = true;
                    arrayDeque.addLast(adjList[now].get(i));
                    sb.append(adjList[now].get(i)+" ");
                }

            }
        }

    }

    public static void dfs(int now){
        if(visited[now]) return;

        visited[now] = true;
        sb.append(now+" ");

        for(int i=0; i<adjList[now].size(); i++){
            if(!visited[adjList[now].get(i)]){
                dfs(adjList[now].get(i));
            }
        }
    }
}
