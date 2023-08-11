import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class RideTaxiTogether {
    public static int n = 6; // 지점 개수
    public static int s = 4; // 출발 지점
    public static int a = 6; // a 도착 지점
    public static int b = 2; // b 도착 지점
    public static int[][] fares = {{4,1,10}, {3,5,24}, {5,6,2}, {3,1,41}, {5,1,24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
    public static void main(String[] args) {
        System.out.println(solution(n, s, a, b, fares));
    }

    public static int solution(int n, int s, int a, int b, int[][] fares){
        int answer = 0;

        // a와 b 지점은 같지 않음

        // s -> a ,  s -> b
        // s -> a -> b or s -> b -> a

        ArrayList<int[]>[] adjList = new ArrayList[n+1];
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
        int each = 0;
        boolean[] visitedA = new boolean[n+1];
        boolean[] visitedB = new boolean[n+1];

        int INF = 987654321;
        int[] distA = new int[n+1]; // 거리 계산
        int[] distB = new int[n+1]; // 거리 계산

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });

        Arrays.fill(distA, INF);
        Arrays.fill(distB, INF);

        distA[s] = 0;
        distB[s] = 0;

        pq.add(new int[]{s, 0});
        while(!pq.isEmpty()){
            int[] now = pq.poll();

            if(visitedA[now[0]]) continue;
            visitedA[now[0]] = true;

            for (int i = 0; i < adjList[now[0]].size(); i++) {
                int[] next = adjList[now[0]].get(i);

                if(distA[next[0]] > distA[now[0]] + next[1]){
                    distA[next[0]] = distA[now[0]] + next[1];
                    pq.add(new int[]{next[0], distA[next[0]]});
                }
            }
        }

        pq.add(new int[]{s, 0});
        while(!pq.isEmpty()){
            int[] now = pq.poll();

            if(visitedB[now[0]]) continue;
            visitedB[now[0]] = true;

            for (int i = 0; i < adjList[now[0]].size(); i++) {
                int[] next = adjList[now[0]].get(i);

                if(distB[next[0]] > distB[now[0]] + next[1]){
                    distB[next[0]] = distB[now[0]] + next[1];
                    pq.add(new int[]{next[0], distB[next[0]]});
                }
            }
        }
        each = distA[a] + distB[b];

        // s -> a -> b
        int together = 0;
        boolean[] visited = new boolean[n+1];
        int[] distMixFirst = new int[n+1];
        int[] distMixSecond = new int[n+1];

        Arrays.fill(distMixFirst, INF);
        distMixFirst[s] = 0;
        pq.add(new int[]{s, 0});

        while(!pq.isEmpty()){
            int[] now = pq.poll();

            if(visited[now[0]]) continue;
            visited[now[0]] = true;

            for (int i = 0; i < adjList[now[0]].size(); i++) {
                int[] next = adjList[now[0]].get(i);

                if(distMixFirst[next[0]] > distMixFirst[now[0]] + next[1]){
                    distMixFirst[next[0]] = distMixFirst[now[0]] + next[1];
                    pq.add(new int[]{next[0], distMixFirst[next[0]]});
                }
            }
        }

        visited = new boolean[n+1];
        Arrays.fill(distMixSecond, INF);
        distMixSecond[a] = 0;
        pq.add(new int[]{a, 0});

        while(!pq.isEmpty()){
            int[] now = pq.poll();

            if(visited[now[0]]) continue;
            visited[now[0]] = true;

            for (int i = 0; i < adjList[now[0]].size(); i++) {
                int[] next = adjList[now[0]].get(i);

                if(distMixSecond[next[0]] > distMixSecond[now[0]] + next[1]){
                    distMixSecond[next[0]] = distMixSecond[now[0]] + next[1];
                    pq.add(new int[]{next[0], distMixSecond[next[0]]});
                }
            }
        }

        together = distMixFirst[a] + distMixSecond[b];

        answer = Math.min(each, together);
        return answer;
    }
}
