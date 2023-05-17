public class LargestSquare {
    private static final int [][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
//    private static final int [][] board = {{0,0,1,1}, {1,1,1,1}};
    public static void main(String[] args) {
        System.out.println(solution(board));
    }
    public static int solution(int [][]board)
    {
        int answer = 0;
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if(board[i][j]>0){
                    int min = Math.min(board[i-1][j-1], Math.min(board[i-1][j],board[i][j-1]));
                    //board[i][j] = mint + board[i][j];
                    board[i][j] =  min + 1;
                    answer = Math.max(answer, board[i][j]);
                }

            }
        }
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                answer = Math.max(answer, board[i][j]);
//            }
//        }
        System.out.println(answer);
        return answer*answer;
    }
}
