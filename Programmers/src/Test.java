
import java.io.IOException;


public class Test {
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
       int[][] board = {{0,0}, {0, 1}, {1, 0 }, {1, 1}};

        for (int i = 0; i < board.length; i++) {
            int y= board[i][0];
            int x =board[i][1];
            System.out.println("시작점 "+ x + " " + y);
            // 상하좌우 탐색
            for (int j = 0; j < 4; j++) {
                int r = y + ry[j];
                int c = x + rx[j];
                System.out.println("이동점"+ r + " " + c);
            }
            System.out.println();
        }
    }
}
