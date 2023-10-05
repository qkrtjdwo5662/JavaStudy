import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_11724_bfs_2 {
    public static ArrayList<Integer>[] adjList;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n+1];
        for (int i = 1; i <=n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }

        int answer = 0;
        visited = new boolean[n+1];
        for (int i = 1; i <= n ; i++) {
            if(!visited[i]){
                bfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void bfs(int start){
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.addLast(start);
        visited[start] = true;

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
