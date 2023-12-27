package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Digit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();

        int answer =0;

        for (int i = 0; i < number.length(); i++) {
            int num = number.charAt(i) - '0';
            answer += num;
        }

        System.out.println(answer);
    }
}
