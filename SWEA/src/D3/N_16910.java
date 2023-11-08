package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_16910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc ; i++) {
            int n = Integer.parseInt(br.readLine());

            int answer = 0;
            int powN = (int) Math.pow(n, 2);
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n ; k++) {
                    int sum = (int) (Math.pow(j , 2) + Math.pow(k, 2));
                    if(sum <= powN) answer++;
                }
            }
            answer *= 4;
            answer += n*4+1;


            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
