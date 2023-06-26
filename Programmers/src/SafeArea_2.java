import java.util.ArrayList;

public class SafeArea_2 {
    public static int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}};
    public static int[] rx = {0, 0, 1, -1, 1,-1,-1,1};
    public static int[] ry = {1, -1, 0, 0, 1,1,-1,-1 };

    public static void main(String[] args) {
        System.out.println(solution(board));
    }
    public static int solution(int[][] board){
        int answer =0;

        ArrayList<int[]> arrayList = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] ==1) arrayList.add(new int[]{i,j}); // 폭탄 위치 넣기
            }
        }

        for (int i = 0; i < arrayList.size(); i++) {
            int[] now = arrayList.get(i);
            for (int j = 0; j < 8; j++) {
                int r = now[0] + ry[j];
                int c = now[1] + rx[j];

                if(r<0 || c<0 || r>= board.length || c>= board[0].length) continue; // 범위 벗어나면 X

                board[r][c] = 1; // 위험지대 표시
            }

        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 0) answer ++;
            }
        }

        return answer;
    }
}
