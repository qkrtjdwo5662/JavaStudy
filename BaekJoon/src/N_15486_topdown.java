import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_15486_topdown {
    static int n;
    static int[][] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        arr = new int[n][2];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        int answer = go(0);
        sb.append(answer).append("\n");
        System.out.println(sb);
    }
    static int go(int depth){
        if(depth >= n ){
            return 0;
        }

        if(dp[depth] != 0) return dp[depth]; // 이미 기록되어있으면 리턴

        int max = 0;

        // 선택을 할 수도 있고, 안하고 다음으로 넘길수도 있음
        if(depth + arr[depth][0] <= n ){
            max = Math.max(go(depth + arr[depth][0]) + arr[depth][1], go(depth + 1));
        }else max = go(depth + 1);

        dp[depth] = max;

        return max;
    }
}
