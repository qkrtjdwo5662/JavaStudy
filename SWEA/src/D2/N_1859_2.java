package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1859_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int price = Integer.parseInt(st.nextToken());
                arr[j] = price;
            }
            int max = 0;
            long sum = 0;

            for (int j = n-1; j >=0 ; j--) {
                if(max > arr[j]){
                    sum = sum + (max - arr[j]);
                }else{
                    max = arr[j];
                }
            }
            sb.append("#").append(i).append(" ").append(sum).append("\n");
        }
        System.out.print(sb);
    }
}


// 2 ~ 1_000_000개의 tc
// 매매가는 10_000 이하

// 최대 매매가의 합 1_000_000 X 10_000 = 10_000_000_000 : 100억