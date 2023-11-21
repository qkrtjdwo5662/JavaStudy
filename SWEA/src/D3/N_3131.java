package D3;

import java.io.IOException;


public class N_3131 {
    public static final int MAX = 1_000_000;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        loop:
        for (int i = 2; i <=MAX ; i++) {
            int sqrt = (int)Math.sqrt(i);
            for (int j = 2; j <= sqrt ; j++) {
                if(i%j == 0) continue loop;
            }
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
