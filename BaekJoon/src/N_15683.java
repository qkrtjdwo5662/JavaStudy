import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_15683 {
    public static int n;
    public static int m;
    public static int answer;
    public static int[] ry = {1, 0, -1, 0};
    public static int[] rx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        ArrayList<int[]> cctvList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;

                if(num == 1 ||num == 2 || num == 3 || num == 4 || num == 5){ // 1, 2, 3, 4, 5
                    cctvList.add(new int[]{num, i, j});
                }
            }
        }
        answer = n*m;
        dfs(cctvList, 0, board);
        System.out.println(answer);

    }
    public static void dfs(ArrayList<int[]> list, int depth, int[][] board){
        if(depth == list.size()){
            answer = Math.min(answer, check(board));
            return;
        }

        int[] now = list.get(depth);
        if(now[0] == 1) {
            // 상, 하 , 좌, 우
            for (int i = 0; i < 4; i++) {
                change(i, now[1], now[2], board, -1);
                dfs(list, depth+1, board);
                change(i, now[1], now[2], board, 0);
            }
        }else if(now[0] == 2){
            // 상하, 좌우
            for (int i = 0; i < 2; i++) {
                change(i, now[1], now[2], board, -1);
                change(i+2, now[1], now[2], board, -1);
                dfs(list, depth+1, board);
                change(i, now[1], now[2], board, 0);
                change(i+2, now[1], now[2], board, 0);
            }

        }else if(now[0] == 3){
            for (int i = 0; i < 4; i++) {
                change(i%4, now[1], now[2], board, -1);
                change((i+1)%4, now[1], now[2], board, -1);
                dfs(list, depth+1, board);
                change(i%4, now[1], now[2], board, 0);
                change((i+1)%4, now[1], now[2], board, 0);
            }

        }else if(now[0] == 4){
            // 좌상우, 상우하, 우하좌
            for (int i = 0; i < 4; i++) {
                change(i%4, now[1], now[2], board, -1);
                change((i+1)%4, now[1], now[2], board, -1);
                change((i+2)%4, now[1], now[2], board, -1);
                dfs(list, depth+1, board);
                change(i%4, now[1], now[2], board, 0);
                change((i+1)%4, now[1], now[2], board, 0);
                change((i+2)%4, now[1], now[2], board, 0);
            }

        }else if(now[0] == 5){
            // 상하좌우
            change(0, now[1], now[2], board, -1);
            change(1, now[1], now[2], board, -1);
            change(2, now[1], now[2], board, -1);
            change(3, now[1], now[2], board, -1);
            dfs(list, depth+1, board);
            change(0, now[1], now[2], board, 0);
            change(1, now[1], now[2], board, 0);
            change(2, now[1], now[2], board, 0);
            change(3, now[1], now[2], board, 0);
        }



    }
    public static void change(int num, int y, int x, int[][] board, int value){
        int r = y;
        int c = x;

        int target = -2;
        if(value == -1){
            target = 0;
        }else if(value == 0){
            target = -1;
        }
        while(true){
            r = r + ry[num];
            c = c + rx[num];

            if(r < 0 || c< 0 || r>=n || c>= m) break;

            if(board[r][c] != target) continue;

            board[r][c] = value;
        }
    }
    public static int check(int[][] board){
        int answer = 0;
        System.out.println(Arrays.deepToString(board));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 0) answer++;
            }
        }

        return answer;
    }
}
