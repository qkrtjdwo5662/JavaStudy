import java.util.ArrayDeque;

public class GameMap_5 {
    public static int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

    public static int n;
    public static int m;

    public static int[][] dist;

    public static int[] ry = {1, -1, 0, 0};
    public static int[] rx = {0, 0, 1, -1};
    public static void main(String[] args) {
        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps){
        n = maps.length;
        m = maps[0].length;


        bfs(new int[]{0,0}, maps);

        if(dist[n-1][m-1] == 0) return -1;
        else return dist[n-1][m-1];
    }

    public static void bfs(int[] start, int[][] maps){
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        dist = new int[n][m];

        visited[start[0]][start[1]] = true;
        dist[start[0]][start[1]] = 1;
        deque.addLast(start);


        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r <0 || c<0 || r>= n || c>= m) continue;

                if(maps[r][c] == 0) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[]{r,c});
                    dist[r][c] = dist[now[0]][now[1]] + 1;
                }
            }
        }


    }
}
