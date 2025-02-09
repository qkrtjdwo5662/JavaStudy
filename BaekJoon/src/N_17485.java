import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_17485 {
    static int n;
    static int m;
    static int[][] arr;
    static int answer;
    static int[] rx = {-1, 0, 1};
    static int[] ry = {1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }
        int[][][] dp = new int[n][m][3];

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j <m ; j++) {
//                for (int k = 0; k < 3; k++) {
//                    dp[i][j][k] = Integer.MAX_VALUE;
//                }
//            }
//        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                dp[0][i][j] = arr[0][i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(isArea(j + rx[0])){

                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                answer = Math.min(dp[n-1][i][j], answer);
            }
        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static boolean isArea(int x){
        if(x < 0 || x >= m ) return false;
        return true;
    }
}
