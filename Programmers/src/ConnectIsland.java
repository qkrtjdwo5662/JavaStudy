import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class ConnectIsland {
    public static int n = 4;
    public static int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
    public static void main(String[] args) {
        System.out.println(solution(n, costs));
    }

    public static int solution(int n, int[][] costs){
        int answer = 0;

        ArrayList<int[]>[] adjList = new ArrayList[n]; // 0 ~ n

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>(); // arrayList 할당
        }

        for (int i = 0; i < costs.length; i++) {
            adjList[costs[i][0]].add(new int[]{costs[i][1],costs[i][2]});
            adjList[costs[i][1]].add(new int[]{costs[i][0],costs[i][2]});
        }

        System.out.println(Arrays.deepToString(adjList));
        boolean[] visited = new boolean[n];
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
//        for (int i = 0; i < n; i++) { // 차례로 방문을 하는데
//            if(!visited[i]){
////                System.out.println(i);
//                visited[i] = true;
//                arrayDeque.addLast(i);
//
//                while(!arrayDeque.isEmpty()){
//                    int now = arrayDeque.pollFirst();
//                    for (int j = 0; j < adjList[now].size(); j++) {
//                        if(!visited[adjList[now].get(j)]){
//                            visited[adjList[now].get(j)] = true;
//                            arrayDeque.addLast(adjList[now].get(j));
////                            System.out.println(adjList[now].get(j));
//                            answer ++;
//                        }
//                    }
//                }
//            }
//        }

        return answer;
    }
}
