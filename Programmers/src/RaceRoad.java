import java.util.ArrayDeque;
import java.util.Arrays;

public class RaceRoad {
    public static int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

    public static int[] ry = {1, -1, 0, 0};
    public static int[] rx = {0, 0, 1, -1};
    public static int n;

    public static void main(String[] args) {
        System.out.println(solution(board));
    }

    public static int solution(int[][] board){
        n = board.length;

        int answer = 0;


        return answer = bfs(board);
    }

    public static int bfs(int[][] board){
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        int[][] cost = new int[n][n];

        int d = -1;
        visited[0][0] = true;
        deque.addLast(new int[]{0, 0});

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = 987654321;
            }
        }
        cost[0][0] = 0;
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r <0  || c < 0 || r >= n || c>= n) continue;

                if(board[r][c] == 1) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[]{r, c});
                    if(d==i || d== -1){
                        cost[r][c] = Math.min(cost[now[0]][now[1]] + 100, cost[r][c]);

                    }else {
                        cost[r][c] = Math.min(cost[now[0]][now[1]] + 600, cost[r][c]);
                    }
                    d = i;
                }
            }
        }

        return cost[n-1][n-1];
    }
}
