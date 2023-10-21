import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_1238_3 {
    public static int n;
    public static final int INF = 987654321;
    public static ArrayList<int[]>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()); // 파티 장소

        adjList = new ArrayList[n+1];
        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m ; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[u].add(new int[]{v,w});
        }
        int answer = 0;

        int[] dist = goHome(x);// party -> home

        //home -> party
        for (int i = 1; i <= n ; i++) {
            int distance = dist[i] + goParty(i, x);

            answer = Math.max(answer, distance);
        }

        System.out.println(answer);

    }

    public static int[] goHome(int start){
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });

        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()){
            int[] now = pq.poll();

            if(visited[now[0]]) continue;

            visited[now[0]] = true;

            for (int i = 0; i < adjList[now[0]].size() ; i++) {
                int[] next = adjList[now[0]].get(i);

                if(dist[next[0]] > dist[now[0]] + next[1]){
                    dist[next[0]] = dist[now[0]] + next[1];
                    pq.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }

        return dist;
    }

    public static int goParty(int start, int end){
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });

        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()){
            int[] now = pq.poll();

            if(visited[now[0]]) continue;

            visited[now[0]] = true;

            for (int i = 0; i < adjList[now[0]].size() ; i++) {
                int[] next = adjList[now[0]].get(i);

                if(dist[next[0]] > dist[now[0]] + next[1]){
                    dist[next[0]] = dist[now[0]] + next[1];
                    pq.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }

        return dist[end];
    }
}
