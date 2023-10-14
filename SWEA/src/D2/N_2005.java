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
            //      1
            //    1   1
            // 2C0 2C1 2C2
            // 3C0 3C1 3C2 3C3
            for (int j = 0; j < n; j++) {
                if(j == 0){
                    sb.append("1");
                }else{
                    for (int k = 0; k <= j ; k++) {
                        if(k ==0 || k == j){
                            sb.append("1").append(" ");
                        }else{
                            int r = k;
                            if(r > j/2) r = j-r;
                            int num = 1;
                            for (int l = 1; l <= r ; l++) {
                                num = num * (j-l + 1) / l;
                            }
                            sb.append(num).append(" ");
                        }
                    }
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);
    }
}
