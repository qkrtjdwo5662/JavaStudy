package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_4193 {
    public static int n;
    public static int[][] board;
    public static boolean[][] visited;
    public static int[] ry = {1, -1, 0, 0};
    public static int[] rx = {0, 0, 1, -1};
    public static int[][] timeBoard;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            board = new int[n][n];
            visited = new boolean[n][n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    board[j][k] = num;
                }
            }
            st = new StringTokenizer(br.readLine());
            int[] start = new int[2]; // 시작점
            for (int j = 0; j < 2; j++) {
                start[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int[] end = new int[2]; // 목표지점
            for (int j = 0; j < 2; j++) {
                end[j] = Integer.parseInt(st.nextToken());
            }
            // start -> end
            // 0 : 길, 1 : 장애물, 2 : 소용돌이
            // 소용돌이 2초 주기로 사라짐
            // 0, 1 -> O // 2 -> X // 3, 4 -> O // 5-> X // 6, 7 -> O // 8 -> X  : n%3 == 2 -> 소용돌이 사라짐
            if(start[0] == end[0] && start[1] == end[1]) {
                sb.append("#").append(i).append(" ").append(0).append("\n");
                continue;
            }
            sb.append("#").append(i).append(" ").append(dijkstra(start, end)).append("\n");
//            for (int j = 0; j < n; j++) {
//                for (int k = 0; k < n; k++) {
//                    System.out.print(timeBoard[j][k] + " ");
//                }
//                System.out.println();
//            }
        }
        System.out.println(sb);
    }

    static int dijkstra(int[] start, int[] end){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[2], o2[2]);
        });
        timeBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                timeBoard[i][j] = Integer.MAX_VALUE;
            }
        }
        timeBoard[start[0]][start[1]] = 0;
        pq.add(new int[]{start[0], start[1], 0});

        while(!pq.isEmpty()){
            int[] now = pq.poll();

            if(now[0] == end[0] && now[1] == end[1]) {
                return timeBoard[now[0]][now[1]];
            }

            if(visited[now[0]][now[1]]) continue;
            visited[now[0]][now[1]] = true;

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r < 0 || c < 0 || r >= n || c>= n) continue;

                if(board[r][c] == 1) continue;

                if(!visited[r][c]){
                    if(board[r][c] == 0){
                        if(timeBoard[r][c] > timeBoard[now[0]][now[1]] + 1){
                            timeBoard[r][c] = timeBoard[now[0]][now[1]] + 1;
                            pq.add(new int[]{r,c, timeBoard[r][c]});
                        }
                    }else if(board[r][c] == 2){
                       int time = timeBoard[now[0]][now[1]];
                       if(time % 3 == 2){
                           if(timeBoard[r][c] > time + 1){
                               timeBoard[r][c] = time + 1;
                               pq.add(new int[]{r,c, timeBoard[r][c]});
                           }
                       }else if(time % 3 == 1){
                           if(timeBoard[r][c] > time + 2){
                               timeBoard[r][c] = time + 2;
                               pq.add(new int[]{r,c, timeBoard[r][c]});
                           }
                       }else{
                           if(timeBoard[r][c] > time + 3){
                               timeBoard[r][c] = time + 3;
                               pq.add(new int[]{r,c, timeBoard[r][c]});
                           }
                       }
                    }
                }
            }
        }

        return -1;
    }
}
