package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1217 {
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();
        int tc = 10;

        for (int i = 1; i <= tc ; i++) {
            answer = 0;
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            recursive(m, 1, n, n);
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void recursive(int m , int count, int now, int n){
        if(count == m){
            answer = now;
            return;
        }

        recursive(m, count+1, now*n, n);
    }
}
