import java.util.ArrayDeque;

public class NetWork_bfs_3 {
    public static int n = 3;
//    public static int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
    public static int[][] computers = {{1,1,0}, {1,1,1}, {0,1,1}};
    public static boolean[] visited;
    public static void main(String[] args) {
        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int[][] computers){
        int answer = 0;

        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                bfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    public static void bfs(int start, int[][] computers){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        visited[start] = true;
        deque.addLast(start);

        while(!deque.isEmpty()){
            int now = deque.pollFirst();

            for (int i = 0; i < computers[now].length; i++) {
                if(computers[now][i] == 1 && !visited[i]){
                    visited[i] = true;
                    deque.addLast(i);
                }
            }
        }

    }
}
