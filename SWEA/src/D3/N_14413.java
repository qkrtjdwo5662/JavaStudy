package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_14413 {
    public static ArrayDeque<int[]> deque;
    public static int n;
    public static int m;
    public static int[] ry ={1, -1, 0, 0};
    public static int[] rx ={0, 0, 1, -1};
    public static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            board = new int[n][m];

            deque = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();

                for (int k = 0; k < m; k++) {
                    if(s.charAt(k) == '#') {
                        board[j][k] = 1;
                        deque.add(new int[]{j,k});
                    }
                    else if(s.charAt(k) == '.') {
                        board[j][k] = 2;
                        deque.add(new int[]{j,k});
                    }
                }
            }

            if(bfs()){
                sb.append("#").append(i).append(" ").append("possible").append("\n");
            }else{
                sb.append("#").append(i).append(" ").append("impossible").append("\n");
            }

        }
        System.out.println(sb);
    }
    public static boolean bfs(){
//        boolean[][] visited = new boolean[n][m];

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r<0 || c<0 || r>=n || c>= m) continue;

                if(board[now[0]][now[1]] == board[r][c]) return false;

                if(board[r][c] == 0){
                    if(board[now[0]][now[1]] == 1){
                        board[r][c] = 2;
                        deque.addLast(new int[]{r,c});
                    }else{
                        board[r][c] = 1;
                        deque.addLast(new int[]{r,c});
                    }
                }
            }
        }


        return true;
    }
}
