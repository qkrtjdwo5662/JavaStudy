import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_9663 {
    public static int n;
    public static boolean[][] visited;
    public static int answer =0;
    public static int[] rx = {0, 0, 1, -1,-1,1,1,-1 };
    public static int[] ry = {-1,1,0,0, 1,1,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        backtrack(n,0);
        System.out.println(answer);
    }
    public static void backtrack(int n, int depth){
        if(depth == n){ // max
            answer = answer+1;
            return;
        }
        for (int i = 0; i < n; i++) {
//            if(!visited[i][])
        }

    }
}
