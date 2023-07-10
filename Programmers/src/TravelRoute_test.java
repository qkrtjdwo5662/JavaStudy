import java.util.ArrayList;
import java.util.Arrays;

public class TravelRoute_test {
    public static int[][] tickets = {{1, 3}, {2, 4}, {3, 2}};
    public static int n = 4;

    public static ArrayList<Integer>[] adjList;
    public static ArrayList<Boolean>[] visited;
    public static ArrayList<Integer> answer;
    public static void main(String[] args) {
        adjList = new ArrayList[n+1];
        visited = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
            visited[i] = new ArrayList<>();
        }

        for (int i = 0; i < tickets.length; i++) {
            adjList[tickets[i][0]].add(tickets[i][1]);
            visited[tickets[i][0]].add(false);
        }

        answer = new ArrayList<>();

        answer.add(1);
        dfs(1);
    }
    public static void dfs(int now){


        for (int i = 0; i < adjList[now].size(); i++) {
            if(!visited[now].get(i)){
                visited[now].remove(i);
                visited[now].add(i, true);
                answer.add(adjList[now].get(i));
                dfs(adjList[now].get(i));
            }
        }
    }

}
