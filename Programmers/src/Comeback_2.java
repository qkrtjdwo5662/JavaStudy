import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Comeback_2 {
    public static int n = 5;
    public static int[][] roads = {{1,2}, {1,4}, {2,4}, {2,5}, {4,5}};
    public static int[] sources = {1,3, 5};
    public static int destination = 5;

    public static ArrayList<Integer>[] adjList;
    public static int[] distance;
    public static final int INF = 987654321;


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(n, roads, sources, destination)));
    }

    public static int[] solution(int n, int[][] roads, int[] sources, int destination){
        adjList = new ArrayList[n+1];

        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < roads.length; i++) {
            adjList[roads[i][0]].add(roads[i][1]);
            adjList[roads[i][1]].add(roads[i][0]);
        }

        dijkstra(n, destination);

        System.out.println(Arrays.toString(distance));

        int[] answer = new int[sources.length];
        for (int i = 0; i < answer.length; i++) {
            if(distance[sources[i]] == INF){
                answer[i] = -1;
            }else{
                answer[i] = distance[sources[i]];
            }
        }
        return answer;
    }

    public static void dijkstra(int n, int start){
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        distance = new int[n+1];
        Arrays.fill(distance, INF);

        pq.add(start);
        distance[start] = 0;

        while(!pq.isEmpty()){
            int now = pq.poll();
            System.out.println(now);
            if(visited[now]) continue;
            visited[now] = true;

            for (int i = 0; i < adjList[now].size(); i++) {
                int next = adjList[now].get(i);

                if(distance[next] > distance[now] + 1){
                    distance[next] = distance[now] + 1;
                    pq.add(next);
                }
            }
        }

    }
}

