package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1208_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = 10;

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            int dump = Integer.parseInt(st.nextToken());
            int[] arr = new int[101];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 100; j++) {
                int index = Integer.parseInt(st.nextToken());
                arr[index] += 1;
            }


            while(dump > 0){
                int min = 0;
                int max = 0;
                for (int j = 1; j <= 100 ; j++) {
                    if(arr[j] > 0){
                        min = j;
                        break;
                    }
                }
                for (int j = 100; j >0 ; j--) {
                    if(arr[j] > 0){
                        max = j;
                        break;
                    }
                }
                arr[min] -= 1;
                arr[min+1] += 1;
                arr[max] -= 1;
                arr[max-1] +=1;

                dump -= 1;

            }
            int min = 0;
            int max = 0;
            for (int j = 1; j <= 100 ; j++) {
                if(arr[j] > 0){
                    min = j;
                    break;
                }
            }
            for (int j = 100; j >0 ; j--) {
                if(arr[j] > 0){
                    max = j;
                    break;
                }
            }
            int answer =  max - min;


            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);

    }
}
