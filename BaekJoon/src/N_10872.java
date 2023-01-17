import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int f = 1;
        if(n==0){
            System.out.println(f);
        }else{
            for (int i = 1; i <=n ; i++) {
                    f = f*i;
            }
            System.out.println(f);
        }
    }
}
