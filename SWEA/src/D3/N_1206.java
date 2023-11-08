package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int tc = 10;

        for (int i = 1; i<= tc ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] buildings = new int[n];
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {

                int height = Integer.parseInt(st.nextToken());
                buildings[j] = height;
            }

            for (int j = 2; j < n-2; j++) {
                int max = Math.max(Math.max(buildings[j-1], buildings[j-2]), Math.max(buildings[j+1], buildings[j+2]));

                if(buildings[j] > max) answer += buildings[j] - max;
            }

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
