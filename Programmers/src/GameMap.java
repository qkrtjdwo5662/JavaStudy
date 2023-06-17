import java.util.ArrayDeque;
import java.util.Arrays;

public class GameMap {
    public static int[][] map = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

    public static final int[] rx = {0,0,1,-1};
    public static final int[] ry = {1,-1,0,0};
    public static void main(String[] args) {
        System.out.println(solution(map));
    }

    public static int solution(int[][] map){
        int answer = 0;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        int[][] dist = new int[map.length][map[0].length];

        queue.addLast(new int[]{0,0});
        visited[0][0] = true;
        dist[0][0] = 1;

        while(!queue.isEmpty()){
            int[] node = queue.pollFirst();
            for (int i = 0; i < 4; i++) {
                int r = node[0] + rx[i];
                int c = node[1] + ry[i];

                if(r <0 || r>map.length-1 || c<0 || c>map[0].length-1) continue;

                if(map[r][c]==0) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    queue.addLast(new int[]{r,c});
                    dist[r][c] = dist[node[0]][node[1]]+1;
                }
            }
        }
        System.out.println(Arrays.deepToString(dist));
        answer = dist[dist.length-1][dist[0].length-1];
        return answer;
    }
}
