import java.util.ArrayDeque;
import java.util.ArrayList;

public class FarthestNode_2 {
    public static int n = 6;
    public static int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

    public static void main(String[] args) {
        System.out.println(solution(n, edge));
    }

    public static int solution(int n, int[][] edge){
        int answer = 0;

        ArrayList<Integer>[] adjList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            adjList[edge[i][0]].add(edge[i][1]);
            adjList[edge[i][1]].add(edge[i][0]);
        }


        boolean[] visited = new boolean[n+1];
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int[] distance = new int[n+1];

        distance[1] = 0;
        visited[1] = true;
        arrayDeque.add(1);

        while(!arrayDeque.isEmpty()){
            int now = arrayDeque.poll();
            for (int i = 0; i < adjList[now].size(); i++) {
                if(!visited[adjList[now].get(i)]){
                    visited[adjList[now].get(i)] = true;
                    arrayDeque.add(adjList[now].get(i));
                    distance[adjList[now].get(i)] = distance[now] + 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < distance.length; i++) {
            max = Math.max(max, distance[i]);
        }

        for (int i = 1; i < distance.length; i++) {
            if(distance[i] == max) answer++;
        }

        return answer;
    }
}
