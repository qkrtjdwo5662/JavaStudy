package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_15758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            StringBuilder s = new StringBuilder(st.nextToken());
            StringBuilder t = new StringBuilder(st.nextToken());

            int gcd = getGCD(s.length(), t.length());
            int lcm = s.length() * t.length()/ gcd;

            s.append(String.valueOf(s).repeat(Math.max(0, lcm / s.length() -1)));
            t.append(String.valueOf(t).repeat(Math.max(0, lcm / t.length() - 1)));
            System.out.println(s);
            System.out.println(t);
            if(s.toString().equals(t.toString())){
                sb.append("#").append(i).append(" ").append("yes").append("\n");
            }else{
                sb.append("#").append(i).append(" ").append("no").append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int getGCD(int num1, int num2){
        if(num1 % num2 == 0) return num2;

        return getGCD(num2, num1 % num2);
    }
}
