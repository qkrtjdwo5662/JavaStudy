import java.util.ArrayDeque;
import java.util.Arrays;

public class Shortest {
    public static int[][] map = {{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};
    public static int[] rx ={0, 0, 1, -1}; // 좌우
    public static int[] ry ={1, -1, 0, 0}; // 상하
    public static void main(String[] args) {
        boolean [][] check = new boolean[map.length][map[0].length]; // 방문 체크
        ArrayDeque<int[]> arrayDeque = new ArrayDeque<>(); // 큐 사용 (방문지점 넣었다 뺐다)
        int[][] dist = new int[map.length][map[0].length];

        check[0][0] = true;
        arrayDeque.addLast(new int[]{0,0});
        dist[0][0] = 1; // 칸 수 포함이면 1 포함하지 않으면 0

        while(!arrayDeque.isEmpty()){ // 큐에 더 이상 넣은 것이 없다면 즉 모든 탐색 마친다면 중단
            int[] now = arrayDeque.pollFirst(); // 꺼낸 좌표 // 처음은 0,0
            for (int i = 0; i < 4; i++) { // 상하좌우 탐색 시작
                int r = now[0] + rx[i];
                int c = now[1] + ry[i];

                if(r<0 || r>= map.length || c<0 || c>= map.length){ // 맵에 벗어난 x,y 좌표라면
                    continue;
                }

                if(map[r][c] == 0){ // 갈 수 있는 경로가 아니라면 0
                    continue;
                }

                if(!check[r][c]){ // 위의 조건들에 걸리지 않았으면 방문했는지 체크 여부 확인
                    check[r][c] = true; // 방문 표시 해주고
                    arrayDeque.addLast(new int[]{r,c}); // 큐에 담아주고
                    dist[r][c] = dist[now[0]][now[1]] + 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(dist));
    }
}
