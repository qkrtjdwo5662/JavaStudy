import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1780 {
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
        answer = new int[3];

        divide(0, 0, n);
        for (int i = 0; i < 3; i++) {
            sb.append(answer[i]).append("\n");
        }

        System.out.print(sb);
    }

    public static void divide(int startX, int startY, int size){
        if(check(startX, startY, size)){
            return;
        }

        // 9개로 나누기
        divide(startX, startY, size/3);
        divide(startX + size/3, startY, size/3);
        divide(startX + (2*size)/3, startY, size/3);

        divide(startX, startY + size/3, size/3);
        divide(startX + size/3, startY + size/3, size/3);
        divide(startX + (2*size)/3, startY + size/3, size/3);

        divide(startX, startY + (2*size)/3, size/3);
        divide(startX + size/3, startY + (2*size)/3, size/3);
        divide(startX + (2*size)/3, startY + (2*size)/3, size/3);
    }

    public static boolean check(int startX, int startY, int size){
        int color = board[startY][startX];

        for (int i = startY; i < startY + size ; i++) {
            for (int j = startX; j < startX + size; j++) {
                if(board[i][j]!=color) return false;
            }
        }

        answer[color+1] = answer[color+1]+1;
        return true;
    }
}
