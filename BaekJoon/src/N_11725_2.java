import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_11725_2 {
    public static int n;
    public static int[] parent;
    public static ArrayList<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n+1];
        parent = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }
        bfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n ; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int start){
        boolean[] visited = new boolean[n+1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        visited[start] = true;
        parent[start] = start;
        deque.addLast(start);

        while(!deque.isEmpty()){
            int now = deque.pollFirst();

            for (int i = 0; i < adjList[now].size(); i++) {
                int next = adjList[now].get(i);

                if(!visited[next]){
                    visited[next] = true;
                    deque.addLast(next);
                    parent[next] = now;
                }
            }
        }


    }

//    public static void union(int a, int b){
//        int x = parent[a];
//        int y = parent[b];
//
//        if(a == 1) parent[y] = 1;
//        else if(b == 1) parent[x] = 1;
//        else parent[y] = x;
//    }
//    public static int find(int a){
//        if(parent[a] == a) return parent[a];
//
//        return parent[a] = find(parent[a]);
//    }
}
