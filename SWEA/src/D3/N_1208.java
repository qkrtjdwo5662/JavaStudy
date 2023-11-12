package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1208 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = 10;

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            int count = Integer.parseInt(st.nextToken());
            int answer = 0;
            int[] arr = new int[100];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 100; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            while(count > 0){
                Arrays.sort(arr);

                arr[0] += 1;
                arr[arr.length-1] -= 1;

                count = count -1;
            }
            Arrays.sort(arr);
            answer = arr[arr.length-1] - arr[0];
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
