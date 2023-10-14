package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc ; i++) {
            sb.append("#").append(i).append("\n");

            int n = Integer.parseInt(br.readLine());

            for (int j = 1; j <= n ; j++) {
                if(j == 1 || j==2){ 
                    for (int k = 0; k < j; k++) {
                        sb.append("1").append(" ");
                    }
                    sb.append("\n");
                }else{
                    for (int k = 0; k < j; k++) {
                        if(k==0 || k==j-1){
                            sb.append("1").append(" ");
                        }else{

                            int num = 1;
                            for (int l = 1; l <= k; l++) {
                                num = num * ( (j-l) + 1) / k;
                            }
                            sb.append(num).append(" ");
                        }
                    }
                    sb.append("\n");
                }
            }
            System.out.println(sb);
        }
    }
}
