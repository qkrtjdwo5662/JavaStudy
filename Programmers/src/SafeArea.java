import java.util.Scanner;

public class SafeArea {
    static int[][] board;
    public static void main(String[] args) {

        int[][] board = new int[5][5];
        board[2][2] = 1;
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j < board.length ; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println("");
        }

        System.out.println(solution(board));
    }
    static int solution(int[][] board){
        int count=0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(((i > 1 && i< board.length-1) && (j > 1 && j< board.length-1)) && board[i][j] == 1){
                    board[i-1][j-1]=1;
                    board[i-1][j]=1;
                    board[i-1][j+1]=1;
                    board[i][j-1] =1;
                    board[i][j+1]=1;
                    board[i+1][j-1]=1;
                    board[i+1][j]=1;
                    board[i+1][j+1]=1;
                    break;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]==0){
                    count++;
                }
                System.out.print(board[i][j]+" ");
            }
            System.out.println("");
        }

        return count;
    }
}
