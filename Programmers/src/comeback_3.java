import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class comeback_3 {
    public static int n = 3;
    public static int[][] roads = {{1,2}, {2, 3}};
    public static int[] sources = {2,3};
    public static int destination = 1;

    public static ArrayList<int[]>[] adjList;
    public static final int INF = 987654321;
    public static int[] dist;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(n, roads, sources, destination)));
    }

    public static int[] solution(int n, int[][] roads, int[] sources, int destination){
        int[] answer = new int[sources.length];

        adjList = new ArrayList[n+1];

        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];

            adjList[u].add(new int[]{v, 1});
            adjList[v].add(new int[]{u, 1});
        }

        dijk(destination, n);
        for (int i = 0; i < sources.length; i++) {
            int source = sources[i];
            int result = dist[source];
            if(result == INF){
                answer[i] = -1;
            }else answer[i] = result;
        }

        return answer;
    }
    public static void dijk(int start, int n){
        dist = new int[n+1];
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

            for (int i = 0; i < adjList[now[0]].size(); i++) {
                int[] next = adjList[now[0]].get(i);

                if(dist[next[0]] > dist[now[0]] +1 ){
                    dist[next[0]] = dist[now[0]] + 1;
                    pq.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }


    }

}
