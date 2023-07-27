import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] matrixA = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrixA[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] matrixB = new int[m][k];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k ; j++) {
                matrixB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1 2          -1 -2  0           (-1 + 0 )  (-2 + 0 ) (0 + 6 )    (matrixA[0][0] * matrixB[0][0] + matrixA[0][1] * matrixB[1][0])     (matrixA[0][0] * matrixB[0][1] + matrixA[0][1] * matrixB[1][1])
        // 3 4           0  0  3           (-3 + 0 )  (-6 + 0 ) (0 + 12 )
        // 5 6                             (-5 + 0 )  (-10 + 0 ) (0 + 18 )

        int[][] result = new int[n][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k ; j++) {
                for (int l = 0; l < m; l++) {
                    result[i][j] = result[i][j] + matrixA[i][l] * matrixB[l][j];
                }
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);


    }
}
