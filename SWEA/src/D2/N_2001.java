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
        int sum = 0;
        int [][] array = new int[n][n];

        for (int i = 0; i < array.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        
        for (int i = 0; i <(n-m)*(n-m) ; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k <m ; k++) {
                    sum = sum + array[j][k];
                }
            }
        }


        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(sum);
    }
}
