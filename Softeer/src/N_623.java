import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String secret = br.readLine();

        String user = br.readLine();

        if(m>n){
            System.out.println("normal");
            return;
        }

        user = user.replace(secret, "a");
        if(user.contains("a")){
            System.out.println("secret");
        }else System.out.println("normal");
    }
}
