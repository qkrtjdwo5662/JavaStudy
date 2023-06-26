public class NetWork_5 {
    public static int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
    public static int n = 3;
    public static boolean visited[];
    public static void main(String[] args) {
        System.out.println(solution(computers, n));
    }

    public static int solution(int[][] computers, int n){
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                dfs(computers,i); // 재귀 함수를 통해 1로 연결되어있는 것은 전부 방문 처리
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(int[][] computers, int now){
        if(visited[now]) return; // 방문 했으면 return

        visited[now] = true; // 방문 처리
        for (int i = 0; i < computers.length; i++) {
            if(computers[now][i] == 1){ // 연결되어 있으면 전부 방문처리
                dfs(computers, i);
            }
        }
    }
}
