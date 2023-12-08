package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_4408 {
    public static void main(String[] args) throws IOException {
        // 1 ~ 2, 3 ~ 4 ... 홀~짝이 같은 통로를 공유한다고 생각
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[201]; // 1 ~ 200 통로
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                int now = Integer.parseInt(st.nextToken());
                int target = Integer.parseInt(st.nextToken());

                now = (now + 1) /2;
                target =  (target + 1) /2;
                if(now < target){
                    for (int k = now; k <= target ; k++) {
                        arr[k] ++;
                    }
                }else{
                    for (int k = target; k <= now ; k++) {
                        arr[k] ++;
                    }
                }
                // 지나간 통로에 대해 +1씩 증가

            }
            Arrays.sort(arr);
            int answer = arr[200]; // 정렬 후 가장 큰 값이 흐른 시간
            sb.append("#").append(i).append(" ").append(answer).append("\n");

        }
        System.out.println(sb);
    }
}
