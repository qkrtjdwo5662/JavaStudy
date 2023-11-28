package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_3307_fail {
    public static int[] arr;
    public static int n;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[j] = num;
            }
            answer = 0;
            dfs(0, -1, 0, "");
            sb.append("#").append(i).append(" ").append(answer).append("\n");

        }

        System.out.println(sb);

    }

    public static void dfs(int now, int nowIndex, int count, String s) {
        if (nowIndex == n) { // 배열 끝에 다다르면
            return;
        }
        System.out.println(s);

        answer = Math.max(answer, count);
        for (int i = nowIndex + 1; i < n; i++) {
            if(now < arr[i]){
                dfs(arr[i], i, count+1, s+arr[i]);
            }
        }


        

    }
}
