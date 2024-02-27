package algostudy.week4;

import java.util.Arrays;

public class Rotate {
    static int N = 5;
    static int tx = 1;
    static int ty = 2;
    static int[][] board = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
    };

    // 좌표 (시계 방향) 90도 회전
    public static void rotatePosition(int sx, int sy, int squareSize) {
        // sx , sy => 정사각형 시작점, 2 <= squareSize <= 5
        // Step 1. (sx, sy)를 (0, 0)으로 옮겨 주는 변환을 진행 합니다.
        int ox = tx - sx;
        int oy = ty - sy;

        // Step 2. 변환된 상태 에서, 시계 방향 90도 회전 이후의 좌표
        int rx = oy;
        int ry = (squareSize - ox - 1);

        // Step 3. 다시 (sx, sy)를 더해줍니다.
        tx = rx + sx;
        ty = ry + sy;
    }

    // 사각형 (시계 방향) 90도 회전
    public static int[][] rotateSquare() {
        int col = board.length; // 원래 사각형의 높이 -> 새로운 사각형 가로
        int row = board[0].length; // 원래 사각형의 가로 -> 새로운 사각형 높이

        int[][] newBoard = new int[row][col]; // 돌린 뒤의 사각형
        // 새로운 사각형에 대해
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++) {
                // 새로운 사각형 좌표 = 원래 사각형[ 원래사각형 높이 - 원래 사각형의 높이좌표 - 1 ][ 원래 사각형의 너비좌표 ];
                newBoard[i][j] = board[col - j - 1][i];
            }

        return newBoard;
    }

    public static int[][] rotateReverseSquare() {
        int col = board.length; // 원래 사각형의 높이 -> 새로운 사각형 가로
        int row = board[0].length; // 원래 사각형의 가로 -> 새로운 사각형 높이

        int[][] newBoard = new int[row][col]; // 돌린 뒤의 사각형
        // 새로운 사각형에 대해
        for(int r = 0; r < row; r++)
            for(int c = 0; c < col; c++) {
                // 새로운 사각형 좌표 = 원래 사각형[ ][ 원래 사각형의 너비좌표 ];
                newBoard[r][c] = board[c][row - r - 1];
            }

        return newBoard;
    }


    public static void main(String[] args) {
        rotatePosition(1, 1, 3);
        System.out.println(tx + " : " + ty);

        // 시계방향 회전 후의 사각형
        int[][] myNewBoard = rotateSquare();

        int[][] myReverseNewBoard = rotateReverseSquare();

        for(int[] arr : myNewBoard)
            System.out.println(Arrays.toString(arr));

        System.out.println();

        for(int[] arr : myReverseNewBoard)
            System.out.println(Arrays.toString(arr));
    }
}
