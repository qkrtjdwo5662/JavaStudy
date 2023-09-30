import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_10282_2 {
    public static final int INF = 987654321;
    public static ArrayList<int[]>[] adjList;
    public static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(st.nextToken());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            int c = Integer.parseInt(st.nextToken()); // 감염당한 컴퓨터 번호

            adjList = new ArrayList[n+1];
            for (int j = 1; j <= n ; j++) {
                adjList[j] = new ArrayList<>();
            }

            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());

                int v = Integer.parseInt(st.nextToken());
                int u = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                adjList[u].add(new int[]{v, w});
            }

            dijkstra(c, n);
            int count = 0;
            int time = 0;

            for (int j = 1; j <= n ; j++) {
                if(dist[j] != INF){
                    count++;
                    time = Math.max(time, dist[j]);
                }
            }
            sb.append(count).append(" ").append(time).append("\n");
        }
        System.out.println(sb);
    }

    public static void dijkstra(int start, int n){
        boolean[] visited = new boolean[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });
        dist = new int[n+1];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()){
            int[] now = pq.poll();

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
