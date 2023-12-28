package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1961_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[j][k] = num;
                }
            }

            sb.append("#").append(i).append("\n");
            // degree 90
            //arr[2][0], arr[1][0], arr[0][0]
            //arr[2][1], arr[1][1], arr[1][0]
            //arr[2][2], arr[2][1], arr[2][0]
            for (int j = 0; j < n ; j++) {
                for (int k = n-1; k >= 0; k--) {
                    sb.append(arr[k][j]);
                }
                sb.append(" ");

                for (int k = n-1; k >= 0; k--) {
                    sb.append(arr[(n-1)-j][k]);
                }
                sb.append(" ");

                for (int k = 0; k < n; k++) {
                    sb.append(arr[k][(n-1) -j]);
                }

                sb.append("\n");
            }

//            // arr[2][2] arr[2][1] arr[2][0]
//            // arr[1][2] arr[1][1]
//            for (int j = n-1; j >=0 ;j--) {
//                for (int k = n-1; k >= 0; k--) {
//                    System.out.print(arr[j][k]);
//                }
//                System.out.println();
//            }
//
//            System.out.println();
//            // degree 270
//
//            for (int j= n-1; j >=0 ; j--) {
//                for (int k = 0; k < n; k++) {
//                    System.out.print(arr[k][j]);
//                }
//                System.out.println();
//            }
        }
        System.out.println(sb);
    }
}
