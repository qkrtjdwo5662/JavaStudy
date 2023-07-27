import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2630 {
    public static int[][] board;
    public static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

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
            sb.append(answer[i]).append("\n");
        }

        System.out.print(sb);
    }

    public static boolean check(int startX, int startY, int size){
        int color = board[startY][startX];

        for (int i = startY; i < startY + size; i++) {
            for (int j = startX; j < startX + size; j++) {
                if(board[i][j] != color) return false;
            }
        }

        return true;
    }

    public static void divide(int startX, int startY, int size){
        if(check(startX, startY, size)){
            answer[board[startY][startX]] = answer[board[startY][startX]] + 1;
            return;
        }

        // 쪼개기
        divide(startX, startY, size/2);
        divide(startX + size/2, startY,size/2);
        divide(startX, startY + size/2, size/2);
        divide(startX + size/2, startY + size/2, size/2);


    }
}
