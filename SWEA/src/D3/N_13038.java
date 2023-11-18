package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_13038 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[7];

            for (int j = 0; j < 7; j++) {
                int num = Integer.parseInt(st.nextToken());

                arr[j] = num;
            }

            int answer = Integer.MAX_VALUE;

            int start = 0;
            while(start < 7){
                boolean check = false;
                int remain = target;
                int index = start;
                int day = 0;
                while(remain > 0){
                    if(arr[index%7] == 1){
                        check = true;
                        remain --;
                    }
                    index ++;
                    if(check) {
                        day ++;
                    }
                }
                answer = Math.min(answer, day);
                start ++;
            }



            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
