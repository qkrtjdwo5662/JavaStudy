package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_5789 {
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            arr = new int[n+1];
            for (int j = 1; j <= q ; j++) {
                st = new StringTokenizer(br.readLine());

                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());

                changeBox(left, right, j);
            }

            sb.append("#").append(i).append(" ");
            for (int j = 1; j <= n ; j++) {
                sb.append(arr[j]).append(" ");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }

    public static void changeBox(int start, int end, int num){
        for (int i = start; i <= end ; i++) {
            arr[i] = num;
        }
    }
}
