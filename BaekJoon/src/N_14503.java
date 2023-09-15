import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_14503 {
    public static int n;
    public static int m;
    public static int[] rx = {0, 1, 0, -1};
    public static int[] ry = {1, 0, -1, 0};
    public static int count = 0;
    public static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());
        // 0 : 북
        // 1 : 동
        // 2 : 남
        // 3 : 서

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(new int[]{y, x}, direction);

    }
    public static void clean(int[] start, int direction){
        // 0: 청소해야함
        // 1: 벽
        // 2: 청소 완료 표시

        if(board[start[0]][start[1]] == 0){
            board[start[0]][start[1]] = 2;
            count++;
        }

        for (int i = direction; i < direction+4; i++) {
            int r = start[0] + ry[i%4];
            int c = start[1] + rx[i%4];

            if(board[r][c] == 0){
                clean(new int[]{r,c}, i%4);
            }
        }
    }
}
