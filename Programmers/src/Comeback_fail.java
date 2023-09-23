import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Comeback_fail {
    public static int n = 5;
    public static int[][] roads = {{1,2}, {1,4}, {2,4}, {2,5}, {4,5}};
    public static int[] sources = {1,3, 5};
    public static int destination = 5;

    public static ArrayList<Integer>[] adjList;
    public static ArrayList<Integer> arrayList;
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

        arrayList = new ArrayList<>();
        for (int i = 0; i < sources.length; i++) {
            bfs(sources[i], n, destination);
        }


        int[] answer =new int[sources.length];

        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }

    public static void bfs(int start, int n, int destination){
        if(start == destination) {
            arrayList.add(0);
            return;
        }

        boolean[] visited = new boolean[n+1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int depth = 0;

        visited[start] = true;
        deque.addLast(start);

        while(!deque.isEmpty()){
            int now = deque.pollFirst();

            depth++;
            for (int i = 0; i < adjList[now].size(); i++) {
                int next = adjList[now].get(i);

                if(next == destination) {
                    arrayList.add(depth);
                    return;
                }

                if(!visited[next]){
                    visited[next] = true;
                    deque.add(next);
                }
            }
        }

        arrayList.add(-1);


    }
}
