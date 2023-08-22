public class LargestSquare_2 {
    public static int[][] board = {{0,1,1,1}, {1,1,1,1}, {1,1,1,1}, {0,0,1,0}};
    public static void main(String[] args) {
        System.out.println(solution(board));
    }

    public static int solution(int[][] board){
        int answer = board[0][0];

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if(board[i][j] > 0){
                    int min = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1]));
                    board[i][j] = min + 1;
                    answer = Math.max(board[i][j], answer);
                }
            }
        }
        return answer * answer;
    }
}
