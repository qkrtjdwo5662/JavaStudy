package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            String memory = st.nextToken();
            int[] arr = new int[memory.length()];

            for (int j = 0; j < memory.length(); j++) {
                arr[j] = memory.charAt(j) - '0';
            }


            int answer = 0;

            int index = 0;
            boolean flag = true;

            loop:
            while(true){
                for (int j = 0; j < arr.length; j++) {
                    if(arr[j] == 1){
                        index = j;
                        break;
                    }

                    if(j == arr.length-1) {
                        flag = false;
                    }
                }

                if(!flag) break;
                for (int j = index; j < arr.length; j++) {
                    if(arr[j] == 0){
                        arr[j] = 1;
                    }else {
                        arr[j] = 0;
                    }
                }
                answer = answer+1;
            }

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
