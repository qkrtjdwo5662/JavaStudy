package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1926_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n ; i++) {
            String num = String.valueOf(i);
            if(num.contains("3") || num.contains("6") || num.contains("9")){
                int count = 0;
                for (int j = 0; j < num.length(); j++) {
                    if(num.charAt(j) == '3' || num.charAt(j) == '6' || num.charAt(j) == '9') count ++;
                }

                for (int j = 0; j < count; j++) {
                    sb.append("-");
                }
                sb.append(" ");
            }else{
                sb.append(i).append(" ");
            }
        }

        System.out.print(sb);
    }
}
