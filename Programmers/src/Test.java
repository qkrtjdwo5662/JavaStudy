import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        recursive(n);
    }

    public static int recursive(int n){
        int i;

        if(n<1)
            return 2;
        else
            i= (2 * recursive(n-1) + 1);
            System.out.println(i);
            return i;
    }
}
