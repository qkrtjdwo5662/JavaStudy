import java.util.ArrayDeque;
import java.util.Arrays;

public class PickUpItem_2 {
    public static int[][] rectangle = {{1,1,7,4}, {3,2,5,5}, {4,3,6,9}, {2,6,8,8}};
    public static int characterX = 1; // 시작 x
    public static int characterY = 3; // 시작 y

    public static int itemX = 7; // 목표 x
    public static int itemY = 8; // 목표 y

    public static int n;
    public static int m;
    public static int[][] map;
    public static int[][] distance;
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};
    public static void main(String[] args) {
        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY));
    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY){

        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < rectangle.length; i++) {
            maxX = Math.max(maxX, rectangle[i][2]);
            maxY = Math.max(maxY, rectangle[i][3]);
        }

        n = 2*maxY+1;
        m = 2*maxX+1;

        map = new int[n][m];

        for (int i = 0; i < rectangle.length; i++) {
            int startX = rectangle[i][0];
            int startY = rectangle[i][1];
            int endX = rectangle[i][2];
            int endY = rectangle[i][3];

            for (int j = 2*startY; j <= 2*endY; j++) {
                for (int k = 2*startX; k <= 2*endX ; k++) {
                    map[j][k] = 1;
                }
            }

        }

        for (int i = 0; i < rectangle.length; i++) {
            int startX = rectangle[i][0];
            int startY = rectangle[i][1];
            int endX = rectangle[i][2];
            int endY = rectangle[i][3];

            for (int j = 2*startY+1; j <= 2*endY-1; j++) {
                for (int k = 2*startX+1; k <= 2*endX-1; k++) {
                    map[j][k] = 0;
                }
            }
        }

        bfs(new int[]{2*characterY, 2*characterX}, new int[]{2*itemY, 2*itemX});
        return distance[2*itemY][2*itemX]/2;
    }
    public static void bfs(int[] start, int[] target){
        boolean[][] visited = new boolean[n][m];
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        distance = new int[n][m];

        visited[start[0]][start[1]] = true;
        deque.addLast(new int[]{start[0], start[1]});

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            if(now[0] == target[0] && now[1] == target[1]) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r<0 || c<0 || r>=n || c>=m) continue;

                if(map[r][c] == 0) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[]{r,c});
                    distance[r][c] = distance[now[0]][now[1]] + 1;
                }
            }
        }

//        System.out.println(Arrays.deepToString(distance));
//        System.out.println(distance[target[0]][target[1]]);
    }


}
