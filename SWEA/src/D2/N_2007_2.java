package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2007_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            String s = br.readLine();
            int length = 1;
            boolean flag = false;

            loop:
            while(!flag){
                for (int j = 0; j < length; j++) {
                    if(s.charAt(j) != s.charAt(j+length)){
                        length = length +1;
                        continue loop;
                    }
                }

                flag = true;
            }

            sb.append("#").append(i).append(" ").append(length).append("\n");

        }
        System.out.println(sb);
    }
}
