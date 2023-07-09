import java.util.ArrayDeque;

public class GameMap_3 {
//    public static int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
    public static int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
    public static int[] rx = {0,0,-1,1};
    public static int[] ry = {1,-1,0,0};
    public static void main(String[] args) {
        System.out.println(solution(maps));
    }
    public static int solution(int[][] maps){
        int answer = 0;

        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[][] count = new int[maps.length][maps[0].length];
        ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();

        visited[0][0] = true;
        arrayDeque.addLast(new int[]{0,0});
        count[0][0] = 1;

        while(!arrayDeque.isEmpty()){
            int[] now = arrayDeque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r<0 || c<0 || r>= maps.length || c>=maps[0].length) continue;

                if(maps[r][c] == 0) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    arrayDeque.addLast(new int[]{r,c});
                    count[r][c] = count[now[0]][now[1]] + 1;
                }
            }

        }
        if(count[maps.length-1][maps[0].length-1] == 0) return -1;
        else answer = count[maps.length-1][maps[0].length-1];
        return answer;
    }
}
