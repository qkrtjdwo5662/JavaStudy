package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_18662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            // 등차 수열 조건
            // b - a = c - b = d
            // b = (c - a)/2 = d

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int tolerance = 0;
            double min = Integer.MAX_VALUE;

            tolerance = Math.abs(b-a); // |b-a|
            if(b-a >= 0){
                if(c-b != tolerance){
                    // 0 1 4
                }
            }else{
                if(b-c != tolerance){

                }
            }


            tolerance = c - b;
        }
    }
}
