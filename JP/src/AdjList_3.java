import java.util.ArrayList;
import java.util.Arrays;

public class AdjList_3 {
    public static int[][] input = {{1,2},{2,3},{2,4},{5,2},{5,1},{5,4}}; // 간선
    public static void main(String[] args) {
        //1. 각각의 점의 개수 파악 -> 1~5 총 5 개
        int n = 5;

        ArrayList<Integer>[] adjList = new ArrayList[n+1]; // index 0버리고 1~5사용

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>(); // 각 ArrayList에 ArrayList로
        }

        for (int i = 0; i < input.length; i++) {
            adjList[input[i][0]].add(input[i][1]); // 단 방향 간선
            adjList[input[i][1]].add(input[i][0]); // 양 방향 간선
        }

        System.out.print(Arrays.toString(adjList));


    }
}
