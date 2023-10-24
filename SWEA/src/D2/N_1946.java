package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            sb.append("#").append(i).append("\n");
            int count = 0;
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                String alpha = st.nextToken();
                int length = Integer.parseInt(st.nextToken());

                for (int k = 0; k < length; k++) {
                    sb.append(alpha);

                    count+=1;

                    if(count==10){
                        sb.append("\n");
                        count = 0;
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
