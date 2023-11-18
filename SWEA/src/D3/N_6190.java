package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_6190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[j] = num;
            }
            int answer = 0;

            for (int j = 0; j < arr.length-1; j++) {
                for (int k = j+1; k < arr.length ; k++) {
                    int multi = arr[j] * arr[k];
                    if(check(multi)) answer = Math.max(answer, multi);
                }
            }
            if(answer == 0){
                sb.append("#").append(i).append(" ").append(-1).append("\n");
            }else{
                sb.append("#").append(i).append(" ").append(answer).append("\n");
            }

        }

        System.out.println(sb);
    }

    public static boolean check(int num){
        String s = String.valueOf(num);

        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i-1) - '0' > s.charAt(i) - '0') return false;
        }

        return true;
    }
}
