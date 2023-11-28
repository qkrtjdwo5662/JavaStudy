package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_4299 {
    public static final int promise = 11 * 24 * 60 + 11 * 60 + 11;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());


            int total = 24 * 60* day + 60 * h + m;

            int answer = total - promise;

            if(answer < 0) sb.append("#").append(i).append(" ").append(-1).append("\n");
            else sb.append("#").append(i).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
