import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = 0;
        while(true){
            int n = Integer.parseInt(br.readLine());
            for (int i = 1; ; i++) {
                a = a*10 + 1;
                a = a%n;
                if(a==0){
                    System.out.println(i);
                    break;
                }
            }
        }



    }
}
