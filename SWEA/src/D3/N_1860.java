package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1860 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 손님 명
            int m = Integer.parseInt(st.nextToken()); // m 초마다
            int k = Integer.parseInt(st.nextToken()); // k개 붕어빵 생산

            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int nowCount = 0;
            int nowTime = 0;
            int index = 0;
            boolean flag = true;
            Arrays.sort(arr);

            loop:
            while(index < n){
                if(nowTime != 0 && nowTime % m == 0){
                    nowCount += k;
                }

                if(nowTime > arr[index]){
                    flag = false;
                    break;
                }

                while(nowTime == arr[index]){
                    if(nowCount > 0) {
                        nowCount -= 1;
                        index += 1;
                    }else{
                        flag = false;
                        break loop;
                    }

                    if(index == n) break;
                }


                nowTime += 1;
            }

            if(flag){
                sb.append("#").append(i).append(" ").append("Possible").append("\n");
            }else{
                sb.append("#").append(i).append(" ").append("Impossible").append("\n");
            }
        }
        System.out.println(sb);
    }
}
