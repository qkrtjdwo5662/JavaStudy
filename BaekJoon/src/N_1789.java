import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long sum = 0;
        long index = 0;

        while(sum + index + 1 <= n){
            index ++;
            sum = sum + index;
        }

        System.out.println(index);
    }
}
