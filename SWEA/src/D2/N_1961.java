package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];

            sb.append("#").append(i).append("\n");
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 0; k < n; k++) {
                    int num = Integer.parseInt(st.nextToken());

                    arr[j][k] = num;
                }
            }

            for (int j = 0; j <n; j++) {
                for (int k = n-1; k >=0 ; k--) {
                    sb.append(arr[k][j]);
                }
                sb.append(" ");

                for (int k = n-1; k >=0 ; k--) {
                   sb.append(arr[n-j-1][k]);
                }
                sb.append(" ");

                for (int k=0; k < n; k++) {
                    sb.append(arr[k][n-j-1]);
                }
                sb.append("\n");

            }

        }

        System.out.println(sb);
    }
}
