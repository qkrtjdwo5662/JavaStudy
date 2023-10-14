package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        loop:
        for (int i = 1; i <= tc ; i++) {
            String s = br.readLine();

            for (int j = 0; j < s.length()/2; j++) {
                if(s.charAt(j) != s.charAt(s.length()-1-j)){
                    sb.append("#").append(i).append(" ").append(0).append("\n");
                    continue loop;
                }
            }
            sb.append("#").append(i).append(" ").append(1).append("\n");

        }
        System.out.println(sb);
    }
}
