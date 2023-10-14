package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        int[] arr = new int[11];
        for (int i = 1; i <= 10 ; i++) {
            if(i%2 == 1){
                arr[i] = arr[i-1] + i;
            }else arr[i] = arr[i-1] - i;
        }

        for (int i = 1; i <= tc ; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append("#").append(i).append(" ").append(arr[num]).append("\n");
        }
        System.out.println(sb);
    }
}
