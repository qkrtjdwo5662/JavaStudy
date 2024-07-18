import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1174 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int index = 1;
        int num = 0;
        while(index < n){
            String s = String.valueOf(num);

            boolean flag = true;
            for (int i = 0; i < s.length() - 1; i++) {
                if(s.charAt(i) - '0' <= s.charAt(i + 1) - '0') {
                    flag = false;
                    break;
                }
            }
            if(flag) index++;
            num ++;
        }

        if(index == n) System.out.println(num);
        else System.out.println(-1);
    }
}
