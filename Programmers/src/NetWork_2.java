import java.util.ArrayDeque;
import java.util.ArrayList;

public class NetWork_2 {
    public static int n = 3;
    public static int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
    public static int[][] computers2 = {{1,1,0}, {1,1,1}, {0,1,1}};
    public static void main(String[] args) {
        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int[][] computers){
        int answer = 0;

        ArrayList<Integer>[] adjList = new ArrayList[n];
        boolean[] visited = new boolean[n]; // 방문 체크 용

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>(); // 각 adjList마다 arrayList 생성
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                if(i!=j && computers[i][j] == 1){
                    adjList[i].add(j);
                }
            }
        }

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if(!visited[i]){ // 0부터 탐색
                visited[i] = true; // 탐색 표시 해주고
                arrayDeque.addLast(i); // queue에 넣고
                while(!arrayDeque.isEmpty()){
                    int now = arrayDeque.pollFirst();
                    for (int j = 0; j < adjList[now].size(); j++) {
                        if(!visited[adjList[now].get(j)]){
                            visited[adjList[now].get(j)] = true;
                            arrayDeque.addLast(adjList[now].get(j));
                        }
                    }
                }
                answer ++;
            }
        }

        return answer;
    }
}
