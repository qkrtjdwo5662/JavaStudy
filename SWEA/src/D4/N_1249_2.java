package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_1249_2 {
    public static int n;
    public static int[][] board;
    public static int[] ry = {1, -1, 0, 0};
    public static int[] rx = {0, 0, 1, -1};
    public static int[][] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            board = new int[n][n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int k = 0; k < n; k++) {
                    int num = s.charAt(k) - '0';
                    board[j][k] = num;
                }
            }

            dijkstra();
            sb.append("#").append(i).append(" ").append(time[n-1][n-1]).append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[2], o2[2]);
        });
        boolean[][] visited = new boolean[n][n];
        time = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                time[i][j] = Integer.MAX_VALUE;
            }
        }
        time[0][0] = 0;
        pq.add(new int[]{0, 0, 0});

        while(!pq.isEmpty()){
            int[] now = pq.poll();

            if(visited[now[0]][now[1]]) continue;

            visited[now[0]][now[1]] = true;

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r < 0 || c< 0 || r>= n || c>= n) continue;

                if(time[r][c] > time[now[0]][now[1]] + board[r][c]){
                    time[r][c] = time[now[0]][now[1]] + board[r][c];
                    pq.add(new int[]{r, c, time[r][c]});
                }

            }
        }
    }
}
