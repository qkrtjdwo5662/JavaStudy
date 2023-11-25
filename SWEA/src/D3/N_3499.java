package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_3499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            ArrayDeque<String> first = new ArrayDeque<>();
            ArrayDeque<String> second = new ArrayDeque<>();

            int middle = 0;

            if(n%2 == 0) middle = n/2;
            else middle = n/2 + 1;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                String s = st.nextToken();;
                if(j < middle){
                    first.addLast(s);
                }else{
                    second.addLast(s);
                }
            }


            sb.append("#").append(i).append(" ");
            for (int j = 0; j < n; j++) {
                if(j%2 ==0){
                    sb.append(first.pollFirst()).append(" ");
                }else{
                    sb.append(second.pollFirst()).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
