import java.util.ArrayList;
import java.util.Arrays;

public class Comeback_3_dfs_fail {
//    public static int n = 3;
//    public static int[][] roads = {{1,2}, {2, 3}};
//    public static int[] sources = {2,3};
//    public static int destination = 1;

    public static int n = 5;
    public static int[][] roads = {{1,2}, {1,4}, {2,4}, {2,5}, {4,5}};
    public static int[] sources = {1,3, 5};
    public static int destination = 5;
    public static int result;

    public static ArrayList<Integer>[] adjList;
    public static boolean[] visited;
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

            adjList[u].add(v);
            adjList[v].add(u);
        }

        for (int i = 0; i < sources.length; i++) {
            int source = sources[i];
            result = 987654321;
            visited = new boolean[n+1];

            visited[source] = true;
            dfs(source, 0, destination);

            if(result == 987654321){
                answer[i] = -1;
            }else answer[i] = result;

        }

        return answer;
    }

    public static void dfs(int now, int count, int destination){
        if(now == destination){
            result = Math.min(result, count); // 최소거
            return;
        }


        for (int i = 0; i < adjList[now].size(); i++) {
            int next = adjList[now].get(i);
            if(!visited[next]){
                visited[next] = true;
                dfs(next, count + 1, destination);
                visited[next] = false;
            }
        }
    }
}
