import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Test7777 {
    public static int[] ry ={1, -1, 0, 0};
    public static int[] rx ={0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 가로
            int n = Integer.parseInt(st.nextToken()); // 세로
            int k = Integer.parseInt(st.nextToken()); // 배추 정보

            int[][] board = new int[n][m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                board[y][x] = 1;
            }

            // --------bfs--------------
            // bfs가 실행된 횟수 = 지렁이 개수

            // bfs 하기 위한 재료 준비 => 큐, 방문표시 배열
            boolean[][] visited = new boolean[n][m];
            ArrayDeque<int[]> deque = new ArrayDeque<>();

            int count = 0;

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if(!visited[j][l] && board[j][l] == 1){
                        // 시작점 : j, l
                        // 시작점 큐에 넣고 방문처리

                        deque.addLast(new int[]{j, l});
                        visited[j][l] = true;
                        count ++;

                        // 큐가 빌때까지 반복
                        while(!deque.isEmpty()){
                            int[] now = deque.pollFirst();

                            for (int o = 0; o < 4; o++) {
                                int r = now[0] + ry[o];
                                int c = now[1] + rx[o];
                                // 상하좌우

                                // 조건
                                // 조건 1. 범위를 넘었는지?
                                if(r <0 || c< 0 || r>= n || c >= m) continue;

                                // 조건 2. 배추인지?
                                if(board[r][c] != 1) continue;

                                // 범위를 넘지 않고 배추인값
                                // 방문하지 않았으면 큐에 넣고 방문처리
                                if(!visited[r][c]){
                                    visited[r][c] = true;
                                    deque.addLast(new int[]{r, c});
                                }
                            }


                        }
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);


    }
}
