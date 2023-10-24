package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            int[] result = new int[5];

            while(num % 2 == 0){
                num /= 2;
                result[0] += 1;
            }

            while(num % 3 == 0){
                num /= 3;
                result[1] += 1;
            }
            while(num % 5 == 0){
                num /= 5;
                result[2] += 1;
            }
            while(num % 7 == 0){
                num /= 7;
                result[3] += 1;
            }
            while(num % 11 == 0){
                num /= 11;
                result[4] += 1;
            }

            sb.append("#").append(i).append(" ");
            for (int j = 0; j < 5; j++) {
                sb.append(result[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
