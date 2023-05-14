package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        int [][] array = new int[n][n];

        for (int i = 0; i < array.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < n-m+1; i++) {
            for (int j = 0; j < n-m-+1; j++) {
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    for (int l = 0; l < m; l++) {
                        sum = sum + array[i+k][j+l];
                    }
                }
                if(max<sum){
                    max = sum;
                }
            }
        }
        System.out.println(max);
    }
}
