package bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 비트 수
            int m = Integer.parseInt(st.nextToken()); // 확인 정수

            sb.append("#").append(i).append(" ");
            if(((1 << n) - 1 & m) == (1 << n) - 1){
                sb.append("ON").append("\n");
            }else{
                sb.append("OFF").append("\n");
            }
        }
        System.out.println(sb);
    }
}
