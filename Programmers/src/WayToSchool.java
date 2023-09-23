import java.util.Arrays;

public class WayToSchool {
    public static int m = 4;
    public static int n = 3;
    public static int[][] puddles = {{2,2}};
    public static void main(String[] args) {
        System.out.println(solution(m, n, puddles));
    }

    public static int solution(int m, int n, int[][] puddles){
        int mod = 1000000007;

        int[][] map = new int[n][m];

        for (int i = 0; i < puddles.length; i++) {
            map[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        }

        map[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == -1) continue;

                if(i>0 && map[i-1][j] > 0) map[i][j] = (map[i][j] + map[i-1][j]) % mod;
                if(j>0 && map[i][j-1] > 0) map[i][j] = (map[i][j] + map[i][j-1]) % mod;
            }
        }

        return map[n-1][m-1];
    }
}
