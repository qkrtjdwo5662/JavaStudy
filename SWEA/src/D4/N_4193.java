package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_4193 {
    public static int n;
    public static int[][] board;
    public static boolean[][] visited;
    public static int[][] time;
    public static ArrayDeque<int[]> deque;
    public static int[] ry = {1, -1, 0, 0};
    public static int[] rx = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= tc ; i++) {
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
            int[] start = new int[2];
            for (int j = 0; j < 2; j++) {
                start[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int[] end = new int[2];
            for (int j = 0; j < 2; j++) {
                end[j] = Integer.parseInt(st.nextToken());
            }

            visited[start[0]][start[1]] = true;
            deque = new ArrayDeque<>();
            deque.addLast(start);

            sb.append("#").append(i).append(" ").append(bfs(end)).append("\n");
            System.out.println(Arrays.deepToString(time));
        }
        System.out.println(sb);
    }

    static int bfs(int[] end){
        int nowTime = 0;
        time = new int[n][n];

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            if(now[0] == end[0] && now[1] == end[1]) {
                return time[now[0]][now[1]];
                // 종료
            }

            if(board[now[0]][now[1]] == 2){ // 소용돌이
                // 소용돌이 주기
                // 2, 5, 8, 11
                if(nowTime % 3 == 2){
                    for (int i = 0; i < 4; i++) {
                        int r = now[0] + ry[i];
                        int c = now[1] + rx[i];

                        if(r < 0 || c < 0 || r>= n || c>= n) continue;

                        if(board[r][c] == 1) continue;

                        if(!visited[r][c]){
                            visited[r][c] = true;
                            deque.addLast(new int[]{r, c});
                            time[r][c] = nowTime + 1;
                        }
                    }
                    nowTime++;
                }else{
                    while(nowTime % 3 != 2){
                        nowTime ++;
                    }
                }
            }else if(board[now[0]][now[1]] == 0){

                for (int i = 0; i < 4; i++) {
                    int r = now[0] + ry[i];
                    int c = now[1] + rx[i];

                    if(r < 0 || c < 0 || r>= n || c>= n) continue;

                    if(board[r][c] == 1) continue;

                    if(!visited[r][c]){
                        visited[r][c] = true;
                        deque.addLast(new int[]{r, c});
                        time[r][c] = nowTime + 1;
                    }
                }
                nowTime ++;
            }
        }
        return -1;
    }
}
