package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_19185 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            String[] firstArr = new String[n];
            String[] secondArr = new String[m];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                String s = st.nextToken();
                firstArr[j] = s;
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                String s = st.nextToken();
                secondArr[j] = s;
            }

            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());

            sb.append("#").append(i).append(" ");
            for (int j = 0; j < q; j++) {
                st = new StringTokenizer(br.readLine());
                int year = Integer.parseInt(st.nextToken());
                year = year - 1;

                String s = firstArr[year % n] + secondArr[year % m];
                sb.append(s).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
