import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String bracket=br.readLine();
        int count =0;
        for (int i = 0; i < bracket.length(); i++) {
            if(bracket.charAt(i)=='('){
                if(bracket.charAt(i+1)==')'){
                    count++;
                }else{
                    count = count *2;
                }
            }
        }
        System.out.println(count);


    }
}
