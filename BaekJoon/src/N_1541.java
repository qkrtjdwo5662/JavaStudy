import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String formula = br.readLine(); // 수식

        String[] subtract = formula.split("-"); // 뺄셈을 제외한 나머지 식

        int sum = 0;
        for (int i = 0; i < subtract.length; i++) {
            int num = 0;
            String[] plus = subtract[i].split("\\+");

            for (int j = 0; j < plus.length; j++) {
                num = num + Integer.parseInt(plus[j]);
            } // 더해주고


            if(i ==0 ) sum = num;
            else sum = sum - num;

        }


        System.out.println(sum);

    }
}
