package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_3459 {
    public static long n;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            n = Long.parseLong(st.nextToken());
            answer = Integer.MAX_VALUE;
            dfs(0 , 1);
            if(answer % 2 == 0){
                sb.append("#").append(i).append(" ").append("Bob").append("\n");
            }else{
                sb.append("#").append(i).append(" ").append("Alice").append("\n");
            }


        }
        System.out.println(sb);
    }

    public static void dfs(int count, long now){
        if(now*2 > n){
            answer = Math.min(answer, count);
            return;
        }

        dfs(count + 1, now*2);
        dfs(count + 1, now*2 + 1);

    }
}
