import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2630_3 {
    public static int[][] board;
    public static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = new int[2];

        devide(0, 0, n);
    }

    public static void devide(int x, int y, int size){
        if(checkColor(x, y, size)){

        }

        devide(x, y, size/2);
        devide(x+ size/2, y, size/2);
        devide(x, y+size/2, size/2);
        devide(x+size/2, y+size/2, size/2);


    }
    public static boolean checkColor(int x, int y, int size){
        int color = board[y][x];

        for (int i = y; i < y+size; i++) {
            for (int j = x; j < x+size; j++) {
                if(color != board[i][j]){
                    return false;
                }
            }
        }

        return true;
    }
}
