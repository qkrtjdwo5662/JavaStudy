import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_10451_2 {
    public static ArrayList<Integer>[] adjList;
    public static boolean[] visited;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            
            adjList = new ArrayList[n+1];
            for (int j = 1; j <= n; j++) {
                adjList[j] = new ArrayList<>();
            }
            
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int v = Integer.parseInt(st.nextToken());
                adjList[j].add(v);
            }

            visited = new boolean[n+1];
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if(!visited[j]){
                    dfs(j);
                    count++;
                }
            }
            sb.append(count+"\n");
        }
        System.out.print(sb);
    }
    
    public static void dfs(int now){
        if(visited[now]) return;
        
        visited[now] = true;
        for (int i = 0; i < adjList[now].size(); i++) {
            dfs(adjList[now].get(i));
        }

    }

    public static void bfs(int start){
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        visited[start] = true;
        deque.addLast(start);
        while(!deque.isEmpty()){
            int now = deque.pollFirst();

            for (int i = 0; i < adjList[now].size(); i++) {
                int next = adjList[now].get(i);
                if(!visited[next]){
                    visited[next] = true;
                    deque.addLast(next);
                }
            }
        }
    }
}
