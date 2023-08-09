import java.util.ArrayDeque;

public class GameMap_4 {
    public static int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
    public static int[] rx= {0, 0, -1 ,1};
    public static int[] ry = {1,-1, 0, 0};
    public static void main(String[] args) {
        System.out.println(solution(maps));
    }
    public static int solution(int[][] maps){
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] count = new int[n][m];
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        // 큐에 넣어주고, 방문처리, (0,0) = 1
        deque.addLast(new int[]{0,0});
        visited[0][0] = true;
        count[0][0] = 1;

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r<0 || c<0 || r>=n || c>=m) continue; // 범위 벗어남

                if(maps[r][c] == 0) continue; // 벽

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[] {r,c});
                    count[r][c] = count[now[0]][now[1]] + 1;
                }
            }
        }

        if(count[n-1][m-1] == 0) return -1;
        else return count[n-1][m-1];
    }
}
