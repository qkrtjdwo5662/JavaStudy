import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Delivery {
    public static int N = 5;
    public static int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
    public static int K = 3;

    public static void main(String[] args) {
        System.out.println(solution(N, road, K));
    }

    public static int solution(int N, int[][] road, int K){
        int answer = 0;

        ArrayList<int[]>[] adjList = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < road.length; i++) {
            int u = road[i][0];
            int v = road[i][1];
            int w = road[i][2];

            adjList[u].add(new int[]{v,w});
            adjList[v].add(new int[]{u,w});
        }

        boolean[]visited = new boolean[N+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });
        int[] dist = new int[N+1];
        Arrays.fill(dist, 987654321);

        dist[1] = 0;
        pq.add(new int[] {1,0});

        while(!pq.isEmpty()){
            int[] now = pq.poll();

            if(visited[now[0]]) continue;
            visited[now[0]] = true;

            if(dist[now[0]] <= K) answer ++;

            for (int i = 0; i < adjList[now[0]].size(); i++) {
                if(dist[adjList[now[0]].get(i)[0]] > dist[now[0]] + adjList[now[0]].get(i)[1]){
                    dist[adjList[now[0]].get(i)[0]] = dist[now[0]] + adjList[now[0]].get(i)[1];
                    pq.add(new int[]{adjList[now[0]].get(i)[0], dist[adjList[now[0]].get(i)[0]]});
                }
            }
        }

        return answer;
    }
}
