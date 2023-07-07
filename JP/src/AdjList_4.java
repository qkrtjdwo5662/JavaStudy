import java.util.ArrayList;
import java.util.Arrays;

public class AdjList_4 {
    public static int[][] edges = {{1, 2}, {3, 1}, {3, 2}, {4, 1}, {5, 2}, {5, 4}}; // 간선
    public static int n = 5; // 정점의 수
    public static void main(String[] args) {
        ArrayList<Integer>[] adjList = new ArrayList[n+1]; // 0번 정점 무시, 1 ~ 5 번 정점 사용

        for (int i = 1; i <= n; i++) { // 1 ~ 5 ArrayList 선언
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
            // 양방향 그래프이기에 두 번을 넣어준다.
        }

        System.out.println(Arrays.toString(adjList));
    }
}
