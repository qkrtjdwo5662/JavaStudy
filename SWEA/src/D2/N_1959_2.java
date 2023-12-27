package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1959_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arrayA = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arrayA[j] = num;
            }

            int[] arrayB = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arrayB[j] = num;
            }


            int max = 0;
            // 1
            if(n < m){
                for (int j = 0; j < m-n + 1; j++) {
                    int sum = 0;
                    for (int k = 0; k < n; k++) {
                        sum += arrayA[k] * arrayB[k + j];
                    }
                    max = Math.max(sum, max);
                }
            }else{
                for (int j = 0; j < n-m + 1; j++) {
                    int sum = 0;
                    for (int k = 0; k < m; k++) {
                        sum += arrayA[k + j] * arrayB[k];
                    }
                    max = Math.max(sum, max);
                }
            }
            sb.append("#").append(i).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
