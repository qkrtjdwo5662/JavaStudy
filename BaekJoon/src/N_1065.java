import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int answer =0;

        // 한수 : X의 각 자리가 등차수열을 이루면 그 수는 한수
        for (int i = 1; i <= n; i++) {
            if(i < 100 ) {
                answer++;
                continue;
            }

            int firstNum = i %10;
            int secondNum = (i /10)%10;
            int thirdNum = ((i /10)/10)%10;
            if(i!=1000 && (thirdNum-secondNum) == (secondNum - firstNum)) answer ++;

        }
        System.out.println(answer);
    }
}
