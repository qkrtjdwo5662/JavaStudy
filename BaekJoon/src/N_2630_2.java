import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2630_2 {
    public static int[] answer;
    public static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = new int[2];
        divide(0, 0, n);

        for (int i = 0; i < 2; i++) {
            System.out.println(answer[i]);
        }
    }
    public static void divide(int x, int y, int size){
        if(checkColor(x, y, size)){ // 탐색
            return;
        }

        // 분할
        divide(x, y, size/2);
        divide(x + size/2, y, size/2);
        divide(x, y + size/2, size/2);
        divide(x + size/2, y + size/2, size/2);
    }

    public static boolean checkColor(int x, int y, int size){
        int color = board[x][y];

        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size ; j++) {
                if(board[i][j] != color) return false;
            }
        }

        answer[color] = answer[color] + 1;
        return true;
    }
}
