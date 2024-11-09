import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_15649_3 {
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        arr = new int[m];
        backtrack(n, m, 0);
    }

    static void backtrack(int n, int m, int depth){
        if(depth == m){
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                backtrack(n, m, depth + 1);
                visited[i] = false;
            }

        }
    }
}
