package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2817 {
    public static int n;
    public static int k;
    public static int[] arr;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            answer = 0;
            dfs(0, 0);

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int now, int index){
        if(now == k){
            answer += 1;
            return;
        }

        if(index == n){
            return;
        }

        dfs(now, index+1);
        if(now + arr[index] <= k){
            dfs(now + arr[index], index+1);
        }

    }
}
