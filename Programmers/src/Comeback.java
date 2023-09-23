import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Comeback {
    public static int n = 5;
    public static int[][] roads = {{1,2}, {1,4}, {2,4}, {2,5}, {4,5}};
    public static int[] sources = {1,3, 5};
    public static int destination = 5;
    public static final int INF = 987654321;

    public static ArrayList<int[]>[] adjList;;
    public static int[] distance;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(n, roads, sources, destination)));


    }
    public static int[] solution(int n, int[][] roads, int[] sources, int destination){
        adjList = new ArrayList[n+1];
        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < roads.length; i++) {
            adjList[roads[i][0]].add(new int[]{roads[i][1], 1});
            adjList[roads[i][1]].add(new int[]{roads[i][0], 1});
        }


        dijkstra(n, destination);
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
        distance = new int[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });
        Arrays.fill(distance, INF);

        pq.add(new int[]{start, 0});
        distance[start] = 0;

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(visited[now[0]]) continue;
            visited[now[0]] = true;

            for (int i = 0; i < adjList[now[0]].size(); i++) {
                int[] next = adjList[now[0]].get(i);

                if(distance[next[0]]> distance[now[0]] + next[1]){
                    distance[next[0]] = distance[now[0]] + next[1];
                    pq.add(new int[]{next[0], distance[next[0]]});
                }
            }
        }
    }
}
