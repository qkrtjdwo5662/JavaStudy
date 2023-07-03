import java.util.ArrayDeque;
import java.util.ArrayList;

public class PowerGrid {
    public static int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
    public static int n = 9;
    public static boolean[] visited;
    public static ArrayList<Integer>[] adjList;
    public static void main(String[] args) {
        System.out.println(solution(n, wires));
    }
    public static int solution(int n, int[][] wires){
        int answer = Integer.MAX_VALUE;

        adjList = new ArrayList[n+1]; // 0~9 인접리스트


        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            adjList[wires[i][0]].add(wires[i][1]);
            adjList[wires[i][1]].add(wires[i][0]);
        }

        for (int i = 0; i < wires.length; i++) {
            int n1 = bfs(wires[i][0], wires[i][1], n);
            int n2 = bfs(wires[i][1], wires[i][0], n);

            answer = Math.min(answer, Math.abs(n1-n2));
        }

        
        return answer;
    }
    public static int bfs(int v1, int v2, int n){
        adjList[v1].remove(Integer.valueOf(v2)); // 삭제하고

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        visited = new boolean[n+1];


        visited[v1] = true; // 방문처리
        arrayDeque.add(v1); // 넣어주고
        int count = 1;
        while(!arrayDeque.isEmpty()){
            int now = arrayDeque.poll(); // 꺼내주고

            for (int i = 0; i < adjList[now].size(); i++) {  // 연결되어 있는거 탐색
                if(!visited[adjList[now].get(i)]){
                    visited[adjList[now].get(i)] = true;
                    arrayDeque.add(adjList[now].get(i));
                    count++;
                }
            }
        }
        adjList[v1].add(v2); // 다시 넣어준다.

        return count;
    }
}
