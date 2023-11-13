package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = 10;

        for (int i = 1; i <= tc ; i++) {
            int t = Integer.parseInt(br.readLine());
            String search = br.readLine();
            String s = br.readLine();

            int answer = 0;
            while(!s.equals(s.replaceFirst(search, ""))){
                s = s.replaceFirst(search, "");
                answer += 1;
            }
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
