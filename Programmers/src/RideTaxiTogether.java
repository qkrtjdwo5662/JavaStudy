import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class RideTaxiTogether {
    public static int n = 7; // 지점 개수
    public static int s = 3; // 출발 지점
    public static int a = 4; // a 도착 지점
    public static int b = 1; // b 도착 지점
    public static int[][] fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};

    public static int INF = 100_000_000;
    public static ArrayList<int[]>[] adjList;
    public static void main(String[] args) {
        System.out.println(solution(n, s, a, b, fares));
    }

    public static int solution(int n, int s, int a, int b, int[][] fares){
        int answer = INF;

        // a와 b 지점은 같지 않음

        adjList = new ArrayList[n+1];
        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < fares.length; i++) {
            int u = fares[i][0];
            int v = fares[i][1];
            int w = fares[i][2];

            adjList[u].add(new int[]{v,w});
            adjList[v].add(new int[]{u,w});
        }
        // s-> i -> a, s -> i -> b

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, dijkstra(s, i, n) + dijkstra(i, a, n) + dijkstra(i, b, n));
        }

        return answer;
    }
    public static int dijkstra(int start, int target, int n){
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });

        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new int[]{start,0});

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

        return dist[target];
    }
}
