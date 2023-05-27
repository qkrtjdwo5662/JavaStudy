import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_3020 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int count = 0;
        int[][] board = new int[m][n+1];

        for(int i=0; i<n; i++){
            int obstacle = Integer.parseInt(br.readLine());
            if(i%2==0){
                for (int j = board.length-1; j > board.length-1-obstacle; j--) {
                    board[j][i] = 1;
                    board[j][board[j].length-1] = board[j][board[j].length-1] +1;
                }
            }else {
                for (int j = 0; j < obstacle; j++) {
                    board[j][i] = 1;
                    board[j][board[j].length-1] = board[j][board[j].length-1] +1;
                }
            }
        }

        for (int i = 0; i < board.length; i++){
           min = Math.min(min, board[i][board[i].length-1]);
        }

        for (int i = 0; i < board.length; i++){
            if(min==board[i][board[i].length-1]) count++;
        }

        System.out.println(min+" "+count);

        long end = System.currentTimeMillis();
        System.out.println((end - start)/1000.0);
    }
}
