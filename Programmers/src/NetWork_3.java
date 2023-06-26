public class NetWork_3 {

    public static int n = 3;
    public static int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
    public static boolean[] visited;

    public static void main(String[] args) {
        System.out.println(solution(computers, n));
    }
    public static int solution(int[][] computers, int n){
        visited = new boolean[n];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                dfs(computers,i);
                answer++;
            }
        }
        return answer;
    }
    public static void dfs(int[][] computers, int now){
        if(visited[now])
            return;        // 방문 했으면 종료
        visited[now] = true;

        for (int i = 0; i < computers.length; i++) {
            if(computers[now][i] == 1){
                dfs(computers,i);
            }
        }
    }
}
