import java.util.ArrayDeque;
import java.util.ArrayList;

public class PowerGrid_3 {
    public static int n = 9;
    public static int[][] wires = {{1,3}, {2,3},{3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}};

    public static ArrayList<Integer>[] adjList;
    public static boolean[] visited;

    public static void main(String[] args) {
        System.out.println(solution(n, wires));
    }

    public static int solution(int n, int[][] wires){
        int answer = Integer.MAX_VALUE;

        adjList = new ArrayList[n+1];

        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            int u = wires[i][0];
            int v = wires[i][1];

            adjList[u].add(v);
            adjList[v].add(u);
        }

        for (int i = 0; i < wires.length; i++) {
            int u = wires[i][0];
            int v = wires[i][1];

            adjList[u].remove(Integer.valueOf(v));
            adjList[v].remove(Integer.valueOf(u));

            int count = 0;
            int first = 0;
            int second = 0;
            visited = new boolean[n+1];
            for (int j = 1; j <= n ; j++) {
                if(count == 0 && !visited[j]){
                    first = bfs(j);
                    count++;
                } else if (count!=0 && !visited[j]) {
                    second = bfs(j);
                }
            }

            answer = Math.min(Math.abs(first-second), answer);
            adjList[u].add(v);
            adjList[v].add(u);
        }



        return answer;


    }

    public static int bfs(int start){
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.addLast(start);
        visited[start] = true;
        int count = 1;

        while(!deque.isEmpty()){
            int now = deque.pollFirst();

            for (int i = 0; i < adjList[now].size(); i++) {
                int next = adjList[now].get(i);

                if(!visited[next]){
                    visited[next] = true;
                    deque.addLast(next);
                    count++;
                }
            }
        }

        return count;
    }
}
