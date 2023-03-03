import java.util.Scanner;

public class SafeArea {
    static int[][] board;
    static int[] dx = {-1,-1,-1,0,1,1,1,0,0};
    static int[] dy = {-1,0,1,1,1,0,-1,-1,0};
    public static void main(String[] args) {

        int[][] board = new int[5][5];
        board[3][2] = 1;
        board[3][3] = 1;

        System.out.println(solution(board));
    }
    static int solution(int[][] board){
        int answer[][] = new int[board.length][board[0].length];
        int count=0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    bomb(answer, i, j);
                }
            }
        }
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (answer[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    static void bomb(int[][] board, int x, int y){
        int bombX;
        int bombY;

        for (int i = 0; i < 9; i++) {
            bombX = x+dx[i];
            bombY = y+dy[i];

            if((bombX>=0 && bombX<board.length)&&(bombY>=0 && bombY<board.length)){
                board[bombX][bombY] = 1;
            }
        }
    }
}
