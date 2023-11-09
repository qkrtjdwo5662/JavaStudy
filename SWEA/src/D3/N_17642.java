package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_17642 {
    public static int answer;
    public static int[] arr = {2, 3, 5, 7};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if(a==b){
                sb.append("#").append(i).append(" ").append(0).append("\n");
                continue;
            }else if(a>b){
                sb.append("#").append(i).append(" ").append(-1).append("\n");
                continue;
            }

            long differ = Math.abs(a - b);
            if(differ == 1){
                sb.append("#").append(i).append(" ").append(-1).append("\n");
            }else if(differ%2 == 1){
                sb.append("#").append(i).append(" ").append((differ-1)/2).append("\n");
            }else if(differ%2 == 0){
                sb.append("#").append(i).append(" ").append(differ/2).append("\n");
            }



        }

        System.out.println(sb);
    }

}
