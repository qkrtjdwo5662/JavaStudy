import java.util.ArrayDeque;

public class NetWork_bfs {
    public static int n = 3;
    public static int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    public static boolean[] visited;

    public static void main(String[] args) {
        System.out.println(solution(n, computers));
    }
    public static int solution(int n, int[][] computers){
        int answer = 0;
        visited = new boolean[n];
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < computers.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                arrayDeque.addLast(i);
                answer++;
                while(!arrayDeque.isEmpty()){
                    int now = arrayDeque.pollFirst();
                    for (int j = 0; j < computers.length; j++) {
                        if(computers[now][j] == 0) continue;

                        if(!visited[j]){
                            visited[j] = true;
                            arrayDeque.addLast(j);
                        }
                    }
                }
            }
        }

        return answer;
    }
}
