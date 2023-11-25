public class RaceRoad_fail {
    public static int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

    public static boolean[][] visited;
    public static int n;
    public static int m;
    public static int[] ry = {1, -1, 0, 0};
    public static int[] rx = {0, 0, 1, -1};
    public static int answer;

    public static void main(String[] args) {
        System.out.println(solution(board));
    }
    public static int solution(int[][] board){
        answer = Integer.MAX_VALUE;
        n = board.length;
        m = board[0].length;

        visited = new boolean[n][m];
        int[] start = {0, 0};
        visited[0][0] = true;
        for (int i = 0; i < 4; i++) {
            int r = ry[i] + start[0];
            int c = rx[i] + start[1];

            if(r < 0 || c < 0 || r>= n || c>= m) continue;

            if(board[r][c] == 1) continue;
            visited[r][c] = true;
            dfs(board, new int[]{r, c}, i, 100);
            visited[r][c] = false;
        }

        return answer;
    }

    public static void dfs(int[][] board, int[] now, int d, int sum){
        if(now[0] == n-1 && now[1] == m-1){
            answer = Math.min(answer, sum); // answer 갱신
            return;
        }

        for (int i = 0; i < 4; i++) {
            int r = now[0] + ry[i];
            int c = now[1] + rx[i];

            if(r < 0 || c < 0 || r>= n || c>= m) continue; // 범위 넘어가면 X

            if(board[r][c] == 1) continue;

            if(!visited[r][c]){
                visited[r][c] = true;
                if(i == d){
                    dfs(board, new int[]{r, c}, i, sum + 100); // 직

                }else{
                    dfs(board, new int[]{r, c}, i, sum + 600); // 꺾 직

                }

                visited[r][c] = false;
            }
        }
    }
}
