import java.util.ArrayDeque;
import java.util.Arrays;

public class EscapeMaze {
    public static String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
    public static int[] rx = {0,0, 1, -1};
    public static int[] ry = {1,-1, 0, 0};
    public static void main(String[] args) {
        System.out.println(solution(maps));
    }
    public static int solution(String[] maps){

        int n = maps.length;
        int m = maps[0].length();

        int[][] board = new int[n][m];

        int[] start = new int[2];
        int[] lever = new int[2];
        int[] target = new int[2];

        for (int i = 0; i < n; i++) {
            String s = maps[i];
            for (int j = 0; j < m; j++) {
                if(s.charAt(j) == 'S'){ // 시작점
                    start = new int[]{i,j};
                    board[i][j] = 1;
                }else if(s.charAt(j)=='E'){ // 출구
                    target = new int[]{i,j};
                    board[i][j] = 1;
                }else if(s.charAt(j)=='L'){ // 레버
                    lever = new int[]{i,j};
                    board[i][j] = 1;
                }else if(s.charAt(j) == 'O'){
                    board[i][j] = 1;
                }
            }
        }

        boolean[][] visited = new boolean[n][m];
        int[][] distToLever = new int[n][m];
        // start -> lever -> target
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{ start[0] ,start[1]});
        visited[start[0]][start[1]] = true;


        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            if(now[0] == lever[0] && now[1] == lever[1]) break;

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r<0 || c<0 || r>=n || c>=m) continue;

                if(board[r][c] == 0) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[]{r,c});
                    distToLever[r][c] = distToLever[now[0]][now[1]] + 1;
                }
            }
        }

        int distance = 0;

        if(distToLever[lever[0]][lever[1]] == 0) return -1;
        distance = distance + distToLever[lever[0]][lever[1]];

        deque.clear();
        visited = new boolean[n][m];
        deque.addLast(new int[]{ lever[0] ,lever[1]});
        int[][] distToTarget = new int[n][m];
        visited[lever[0]][lever[1]] = true;

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r<0 || c<0 || r>=n || c>=m) continue;

                if(board[r][c] == 0) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[]{r,c});
                    distToTarget[r][c] = distToTarget[now[0]][now[1]] + 1;
                }
            }
        }

        if(distToTarget[target[0]][target[1]] == 0) return -1;
        distance = distance + distToTarget[target[0]][target[1]];
        return distance;

    }
}
