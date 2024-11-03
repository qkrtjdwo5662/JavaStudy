import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_14501_2 {
    static int n;
    static int[][] arr;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 2; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        answer = 0;
        dfs(1, 0);
        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void dfs(int depth, int sum){
        if(depth == n + 1){
            answer= Math.max(answer, sum);
            return;
        }else if(depth > n + 1){
            return;
        }

        dfs(depth + arr[depth][0], sum + arr[depth][1]);
        dfs(depth + 1, sum);


    }
}
