import java.util.ArrayDeque;
import java.util.Arrays;

public class PickUpItem {
    public static int[][] rectangle = {{1,1,7,4}, {3,2,5,5}, {4,3,6,9}, {2,6,8,8}};
    public static int characterX = 1;
    public static int characterY = 3;

    public static int itemX = 7;
    public static int itemY = 8;
    public static int n;
    public static int m;
    public static int[][] board;
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1,-1, 0, 0};

    public static int[][] distance;
    public static void main(String[] args) {
        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY));
    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY){
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < rectangle.length; i++) {
            maxX = Math.max(rectangle[i][2], maxX);
            maxY = Math.max(rectangle[i][3], maxY);
        }

        n = 2*maxY + 1;
        m = 2*maxX + 1;
        board = new int[n][m];

        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0];
            int y1 = rectangle[i][1];
            int x2 = rectangle[i][2];
            int y2 = rectangle[i][3];

            for (int j = 2*y1; j <= 2*y2; j++) {
                for (int k = 2*x1; k <= 2*x2 ; k++) {
                    board[j][k] = 1;
                }
            }

        }

        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0];
            int y1 = rectangle[i][1];
            int x2 = rectangle[i][2];
            int y2 = rectangle[i][3];

            for (int j = 2*y1+1; j <= 2*y2-1; j++) {
                for (int k = 2*x1+1; k <= 2*x2-1; k++) {
                    board[j][k] = 0;
                }
            }

        }


        int[] start = {characterY*2, characterX*2};
        int[] target = {itemY*2, itemX*2};


        bfs(start, target);

        return distance[target[0]][target[1]]/2;



    }

    public static void bfs(int[] start, int[] target){
        boolean[][] visited = new boolean[n][m];
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        distance = new int[n][m];

        visited[start[0]][start[1]] = true;
        deque.addLast(new int[]{start[0], start[1]});

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            if(now[0] == target[0] && now[1] == target[1]) return;

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r<0 || c<0|| r>=n || c>= m) continue;

                if(board[r][c] == 0) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[]{r,c});
                    distance[r][c] = distance[now[0]][now[1]] + 1;
                }
            }
        }

    }
}
