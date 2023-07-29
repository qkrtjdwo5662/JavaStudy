import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1992 {
    public static StringBuilder sb;
    public static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        divide(0, 0, n);
        System.out.println(sb);
    }

    public static void divide(int x, int y, int size){
        if(check(x, y, size)){
            return;
        }
        sb.append("(");
        divide(x, y, size/2);
        divide(x + size/2, y, size/2);
        divide(x, y + size/2, size/2);
        divide(x + size/2, y + size/2, size/2);
        sb.append(")");
    }

    public static boolean check(int x, int y, int size){
        int color = board[y][x];

        for (int i = y; i < y+size; i++) {
            for (int j = x; j < x+size; j++) {
                if(color != board[i][j]) return false;
            }
        }

        sb.append(color);
        return true;
    }
}
