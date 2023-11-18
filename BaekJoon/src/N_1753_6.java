import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_1753_6 {
    public static int n;
    public static ArrayList<int[]>[] adjList;
    public static final int INF = 987654321;
    public static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb=  new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[u].add(new int[]{v, w}); // 방향 그래프
        }

        bfs(start);
        for (int i = 1; i <= n; i++) {
            if(dist[i] == INF){
                sb.append("INF").append("\n");
            }else sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void bfs(int start){
        boolean[] visited = new boolean[n+1];
        dist = new int[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });
        Arrays.fill(dist, INF);

        dist[start] = 0;
        pq.add(new int[] {start, 0});

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            // 0 : 정점
            // 1 : 가중치
            if(visited[now[0]]) continue;
            visited[now[0]] = true;

            for (int i = 0; i < adjList[now[0]].size(); i++) {
                int[] next = adjList[now[0]].get(i);

                if(dist[next[0]] > dist[now[0]] + next[1]){
                    dist[next[0]] = dist[now[0]] + next[1];
                    pq.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }
    }
}
