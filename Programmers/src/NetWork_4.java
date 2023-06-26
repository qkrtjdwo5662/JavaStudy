import java.util.ArrayDeque;
import java.util.ArrayList;

public class NetWork_4 {
    public static int[][] computers = {{1,1,0}, {1,1,1}, {0,1,1}};
    public static int n = 3;
    public static void main(String[] args) {
        System.out.println(solution(computers, n));
    }

    public static int solution(int[][] computers, int n){
        int answer = 0;
        ArrayList<Integer>[] adjList = new ArrayList[n];

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length ; j++) {
                if(i!=j && computers[i][j] == 1 ){
                    adjList[i].add(j);
                    // i==j 일때 제외(무조건 1), computers[i][j]가 1일 때
                    // 단방향 간선으로 넣어줌
                }
            }
        }

        //연결되어 있는 것 끼리는 1개의 개수로 파악
        // 0-1  2  (2개)
        boolean[] visited = new boolean[n]; // 탐색했는지
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if(!visited[i]){ // 순차 탐색을 해주는데
                visited[i] = true;
                deque.addLast(i); // 탐색 한 것 deque에 넣어주고
                while(!deque.isEmpty()){
                    int now = deque.pollFirst(); // deque에서 꺼내서
                    for (int j = 0; j < adjList[now].size(); j++) { // 간선을 통해 타고 들어감
                        if(!visited[adjList[now].get(j)]) {
                            visited[adjList[now].get(j)] = true;
                            deque.addLast(adjList[now].get(j)); // 타고 타고 들어가서 방문했다고 표시 해주기 위함
                        }
                    } // 간선으로 연결된 노드들은 모두 방문했다고 표시하고

                }
                answer ++;
            }
        }


        return answer;
    }
}
