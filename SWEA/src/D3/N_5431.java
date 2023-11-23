package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N_5431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc =Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            HashSet<Integer> set = new HashSet<>();

            for (int j = 0; j < k; j++) {
                int num = Integer.parseInt(st.nextToken());
                set.add(num);
            }

            sb.append("#").append(i).append(" ");
            for (int j = 1; j <= n ; j++) {
                if(!set.contains(j)){
                    sb.append(j).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
