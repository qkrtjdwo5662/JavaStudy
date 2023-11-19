package D3;

import java.io.*;
import java.util.*;


public class N_5607{
    public static final int remain = 1_234_567_891;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for(int i=1; i<=tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int denominate = 1;
            int numerator = 1;

            for(int j = n; j>n-r; j--) {
                numerator *= j;
                numerator %= remain;
            }

            for(int j=1; j<=r; j++) {
                denominate *= j;
                denominate %= remain;
            }
            int answer = 0;

            answer = (int)(numerator / denominate);

//			System.out.println(denominate);
//			System.out.println(numerator);


            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
