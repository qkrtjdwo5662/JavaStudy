import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_9663 {
    public static int n;
    public static boolean[][] visited;
    public static int answer;
    public static int[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n];
        answer = 0;
        backtrack(0);
        System.out.println(answer);
    }
    public static void backtrack(int depth){
        if(depth == n){ // max
            answer = answer+1;
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean check = false;
            for (int j = 0; j < depth; j++) {
                if(board[j] == i || Math.abs(j - depth) == Math.abs(board[j] - i)){
                    check = true;
                    break;
                }
            }
            if(check) continue;
            board[depth] = i;
            backtrack(depth + 1);
        }

    }
}
