package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_1228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = 10;

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 원본 암호문 길이

            ArrayList<String> crypto = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                String s = st.nextToken();
                crypto.add(s);
            }
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken()); // 명령어 수

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < count; j++) {
                String c = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                for (int k = 0; k < y; k++) {
                    String s = st.nextToken();
                    crypto.add(k+x, s);
                }

            }
            StringBuilder answer = new StringBuilder();

            for (int j = 0; j < 10; j++) {
                answer.append(crypto.get(j)).append(" ");
            }

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
