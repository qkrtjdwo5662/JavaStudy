import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int amount = Integer.parseInt(br.readLine());

        //500 , 100, 50, 10, 5, 1
        int remain = 1000 - amount;
        int count = 0;

        while(remain>0){
            if(remain >= 500){
                remain = remain - 500;
                count++;
            } else if (remain >= 100) {
                remain = remain - 100;
                count++;
            } else if (remain >= 50) {
                remain = remain - 50;
                count++;
            } else if (remain >= 10) {
                remain = remain - 10;
                count++;
            } else if (remain >= 5) {
                remain = remain - 5;
                count++;
            } else {
                remain = remain - 1;
                count++;
            }
        }
        System.out.println(count);
    }
}
