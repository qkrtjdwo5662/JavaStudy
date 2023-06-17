import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class NetWork{
    public static int n = 3;
    public static int [][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
    public static void main(String[] args) {
        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int[][] computers){
        int answer = 0;
        ArrayList<Integer>[] adjList = new ArrayList[n]; // computer 3개

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                if(i!=j && computers[i][j]==1){
                    adjList[i].add(j);
                }
            }
        }
        System.out.println(Arrays.toString(adjList));
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        boolean[] visited= new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visited[i]){ // 방문하지 않았으면 방문
                visited[i] = true; // 방문 체크
                deque.addLast(i); // queue에 저장
                
                while(!deque.isEmpty()){ // dfs
                    int now = deque.pollFirst();
                    for (int j = 0; j < adjList[now].size(); j++) {
                        if(!visited[adjList[now].get(j)]){
                            visited[adjList[now].get(j)] = true;
                            deque.addLast(adjList[now].get(j));
                        }
                    }
                }
                answer ++;
            }
        }



        return answer;
    }
}