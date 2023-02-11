import java.io.*;
import java.util.StringTokenizer;

public class N_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        boolean check= false;
        int count =0;
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            check = false;
            if(k==1){
                continue;
            } else if (k==2) {
                count++;
            } else{
                for (int j = 2; j < k; j++) {
                    if(k%j==0){
                        check = false;
                        break;
                    }else{
                        check= true;
                    }
                }
                if(check){
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
