import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_16236 {
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];

        int[] start = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;

                if(num == 9){
                    // 상어 초기 위치
                    start = new int[]{i, j};
                    board[i][j] = 0;
                }
            }
        }

//        System.out.println(Arrays.deepToString(board));

        // 상어의 초기 크기는 2
        // 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다.(지나갈 수도 있음)
        // 상어의 크기와 물고기의 크기가 같다면 지나갈 수는 있음
        // 상어의 크기보다 물고기의 크기가 크다면 지나갈 수 없음

        // 상어가 먹을 수 있는 물고기를 판단
        // 먹을 수 있는 물고기 중 가장 가까운 물고기부터 먹는다.
        // 먹을 수 있는 가장 가까운 물고기가 여러개라면 위에서부터 먹음
        // 위의 물고기로부터 거리가 가장 가까운 물고기가 여러개라면 왼쪽부터 먹는다.
        // 상어 자신의 크기만큼의 물고기를 먹는다면 상어의 크기는 1증가

        // 더이상 먹을 수 있는 물고기가 없다면 종료
        // 상어가 총 이동한 거리는?


        sb.append(bfs(start, n, board));
        System.out.println(sb);
    }

    public static int bfs(int[] now, int n , int[][] board){
        int move = 0;
        int kill = 0;
        int size = 2;

        while(true){
            boolean[][] visited = new boolean[n][n];
            // y, x, 거리
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[2] == o2[2]){ // 같은 거리에 있다면
                        if(o1[0] == o2[0]){ // 같은 y상 위치에 있다면
                            return Integer.compare(o1[1], o2[1]); // x좌표 비교
                        }else{
                            return Integer.compare(o1[0], o2[0]); // y좌표 비교
                        }

                    }else{
                        return Integer.compare(o1[2], o2[2]);
                    }
                } // 거리 비교
            });

            pq.add(new int[]{now[0], now[1], 0}); // 시작 지점
            visited[now[0]][now[1]] = true; // 방문처리
            boolean flag = false;

            while(!pq.isEmpty()){
                now = pq.poll();

                if(board[now[0]][now[1]] != 0 && board[now[0]][now[1]] < size){
                    board[now[0]][now[1]] = 0; // 물고기 잡아 먹었으면 0
                    kill ++; // 먹은거 + 1
                    move += now[2]; // 이동 증가
                    flag = true;

                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int r = now[0] + ry[i];
                    int c = now[1] + rx[i];

                    if(r < 0 || r>= n || c<0 || c>= n) continue;

                    if(board[r][c] > size) continue;

                    if(!visited[r][c]){
                        visited[r][c] = true;
                        pq.add(new int[]{r, c, now[2] + 1});
                    }
                }
            }

            if(!flag){
                break;
            }

            if(size == kill){
                size ++;
                kill = 0;
            }
        }
        return move;
    }
}
