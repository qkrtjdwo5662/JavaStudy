package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            int max = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <10 ; j++) {
                int num = Integer.parseInt(st.nextToken());
                max = Math.max(max, num);
            }

            sb.append("#").append(i).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
