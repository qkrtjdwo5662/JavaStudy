package bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc =Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc; i++) {
            st= new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int index = 0;
            int visit = 0; // bit mask

            // 0 ~ 9까지
            while((visit & ((1 << 10) - 1)) != (1 << 10) - 1 ) {
                index ++;
                int num = n * index;

                String numStr = String.valueOf(num);

                for (int j = 0; j < numStr.length(); j++) {
                    int element = numStr.charAt(j) - '0';
                    visit = (visit | (1 << element));
                }

            }

            sb.append("#").append(i).append(" ").append(n * index).append("\n");
        }
        System.out.println(sb);
    }
}
