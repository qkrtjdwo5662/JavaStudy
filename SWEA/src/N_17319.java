import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_17319 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            boolean answer = true;
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            for (int j = 0; j < n/2; j++) {
                if(s.charAt(j) == s.charAt(j+n/2)){
                    continue;
                }else answer = false; break;
//                System.out.println(j + " " + (j+n/2));
            }


            if(answer && n>1 && n%2==0){
                sb.append("#").append(i).append(" ").append("Yes").append("\n");
            }else  sb.append("#").append(i).append(" ").append("No").append("\n");
        }
        System.out.println(sb);
    }
}
