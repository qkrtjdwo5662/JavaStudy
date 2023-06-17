import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class FarthestNode {
    public static int n = 6;
    public static int [][]edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

    public static void main(String[] args) {
        System.out.print(solution(n, edge));

    }
    public static int solution(int n, int[][] edge){
        int answer = 0;

        ArrayList<Integer>[] adjList = new ArrayList[n+1]; // index 1 ~ 6 사용
        boolean[] visited = new boolean[n+1]; // index 1 ~ 6 사용
        int[] dist = new int[n+1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();


        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i <edge.length ; i++) {
            adjList[edge[i][0]].add(edge[i][1]);
            adjList[edge[i][1]].add(edge[i][0]);
        }

        deque.addLast(1);
        visited[1] = true;
        dist[1] = 0;


        while(!deque.isEmpty()){
            int now = deque.pollFirst();
            for (int i = 0; i < adjList[now].size(); i++) {
                if(!visited[adjList[now].get(i)]){ // 방문 안했으면
                    visited[adjList[now].get(i)] = true;
                    deque.addLast(adjList[now].get(i));
                    dist[adjList[now].get(i)] = dist[now] + 1;
                }
            }

        }
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }

        for (int i = 1; i <= n; i++) {
            if(dist[i] == max){
                answer++;
            }
        }


        System.out.println(Arrays.toString(dist));


        return answer;
    }
}
