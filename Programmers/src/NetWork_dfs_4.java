public class NetWork_dfs_4 {
    public static int n = 3;
    public static int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};

    public static boolean[] visited;
    public static void main(String[] args) {
        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int[][] computers){
        int answer = 0;

        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(i, computers);
                answer ++;
            }
        }

        return answer;
    }
    public static void dfs(int now, int[][] computers){
        for (int i = 0; i < computers[now].length; i++) {
            if(!visited[i] && computers[now][i] == 1){
                visited[i] = true;
                dfs(i, computers);
            }
        }
    }

}
