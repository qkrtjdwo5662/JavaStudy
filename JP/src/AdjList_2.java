import java.util.ArrayList;

public class AdjList_2 {
    public static int[][] input = {{1,2},{2,3},{2,4},{5,2},{5,1},{5,4}}; // 정점, 간선
    public static void main(String[] args) {
        int N = 5; // 정점의 개수

        ArrayList[] adjList = new ArrayList[N+1]; // index 1~5  사용

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>(); // arraList 안에 index 마다 arrayList 생성  // 길이는 가변적
        }

        for (int i = 0; i < input.length; i++) {
            adjList[input[i][0]].add(input[i][1]); // 정점을 index로 간선 정리
        }

        for (int i = 0; i < adjList[5].size(); i++) {
            System.out.println(adjList[5].get(i));
        }

    }
}
