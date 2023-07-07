import java.util.ArrayList;
import java.util.Arrays;

public class FarthestNode_3 {
    public static int n = 6;
    public static int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

    public static boolean[] visited;
    public static int[] distance;
    public static int count;
    public static ArrayList<Integer>[] adjList;
    public static void main(String[] args) {
        System.out.println(solution(n, edge));
    }
    public static int solution(int n, int[][] edge){
        int answer = 0;

        adjList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            adjList[edge[i][0]].add(edge[i][1]);
            adjList[edge[i][1]].add(edge[i][0]);
        }
        System.out.println(Arrays.toString(adjList));
        visited = new boolean[n+1];
        distance = new int[n+1];
        count = 0;

        dfs(1);

        System.out.println(Arrays.toString(distance));
        return answer;
    }
    public static void dfs(int now){
        if(visited[now]) return;

        visited[now] = true;
        distance[now] = count;
        count++;

        for (int i = 0; i <adjList[now].size() ; i++) {
            dfs(adjList[now].get(i));
        }

    }
}
