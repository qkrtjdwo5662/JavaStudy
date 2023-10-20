package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1970 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());



        for (int i = 1; i <= tc ; i++) {
            int n = Integer.parseInt(br.readLine());

            sb.append("#").append(i).append("\n");

            int[] arr = new int[8];

            while(n >= 10){
                if(n >= 50000){
                    arr[0]++;
                    n = n - 50000;
                }else if(n >= 10000){
                    arr[1]++;
                    n = n - 10000;
                }else if(n >= 5000){
                    arr[2]++;
                    n = n - 5000;
                }else if(n >= 1000){
                    arr[3]++;
                    n = n - 1000;
                }else if(n >= 500){
                    arr[4]++;
                    n = n - 500;
                }else if(n >= 100){
                    arr[5]++;
                    n = n - 100;
                }else if(n >= 50){
                    arr[6]++;
                    n = n - 50;
                }else if(n >= 10){
                    arr[7]++;
                    n = n - 10;
                }
            }


            for (int j = 0; j < arr.length; j++) {
                sb.append(arr[j]).append(" ");
            }
            sb.append("\n");

        }

        System.out.println(sb);
    }


}
