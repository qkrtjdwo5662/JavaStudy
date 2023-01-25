import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        //1000보다 작거나 같은 n
        //n : 1~1000
        int count =1;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        for(int i=n; i>0; i--){

        }
        while(n>10){
            n = n/10;
            count +=1;
        }



        System.out.println(count);
        //각 자리수 파악




    }
}
