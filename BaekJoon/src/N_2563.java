import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] board = new int[101][101];
        int n = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = y; j <y+10 ; j++) {
                for (int k = x; k <x+10 ; k++) {
                    board[j][k] = 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(board[i][j] == 1) answer++;
            }
        }

        System.out.println(answer);
    }
}
