import java.util.ArrayDeque;

public class GameMap_2 {
    public static int[][] map = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
    public static int[] rx = {0,0,1,-1};
    public static int[] ry = {1,-1,0,0};
    public static void main(String[] args) {
        System.out.println(solution(map));
    }
    public static int solution(int[][] map){
        int answer = 0;

        boolean[][] visited = new boolean[map.length][map[0].length];
        int[][] dist = new int[map.length][map[0].length];
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        // 시작점
        deque.addLast(new int[]{0, 0});
        visited[0][0] = true;
        dist[0][0] = 1;

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst(); // 현재의 점

            for (int i = 0; i < 4; i++) { // 상하좌우 탐색
                int r = now[0] + rx[i]; // 좌우
                int c = now[1] + ry[i]; // 상하

                // filter 1
                if(r<0 || r>= map.length || c<0 || c>= map[0].length){ // map 크기보다 넘치면
                    continue;
                }

                // filter 2
                if(map[r][c] == 0){ // 연결되어 있지 않으면
                    continue;
                }

                // filter 3
                if(!visited[r][c]){ // 방문하지 않았으면
                    visited[r][c] = true; // 방문 표시
                    deque.addLast(new int[]{r,c});
                    dist[r][c] = dist[now[0]][now[1]] + 1;
                }

            }

        }

        // 종료 지점
        if(dist[dist.length-1][dist[0].length-1] == 0){
            answer = -1;
        }else answer = dist[dist.length-1][dist[0].length-1];


        return answer;
    }
}
