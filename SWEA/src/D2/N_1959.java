package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1959 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr1 = new int[n];
            int[] arr2 = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());

                arr1[j] = num;
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());

                arr2[j] = num;
            }


            int max = Integer.MIN_VALUE;

            // 0 1 2 // 0 1 2
            // 0 1 2 // 1 2 3
            // 0 1 2 // 2 3 4
            if(n <= m){
                for (int j = 0; j < m-n+1; j++) {
                    int sum = 0;
                    for (int k = 0; k < n; k++) {
                        sum += arr1[k] * arr2[k+j];
                    }
                    max = Math.max(max, sum);
                }
            }else{
                for (int j = 0; j < n-m+1; j++) {
                    int sum = 0;
                    for (int k = 0; k < m; k++) {
                        sum += arr1[k+j] * arr2[k];
                    }
                    max = Math.max(max, sum);
                }
            }


            sb.append("#").append(i).append(" ").append(max).append("\n");

        }
        System.out.println(sb);



    }
}
