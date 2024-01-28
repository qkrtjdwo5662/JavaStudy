import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_17419 {
    public static void main(String[] args) throws IOException {
        // K = K-(K&((~K)+1))

        // not k
        // + 1
        // K &
        // K -
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String num_binary = br.readLine();

        int num = Integer.parseInt(num_binary, 2);

        int answer = 0;
        while(num != 0){
            num = num - (num & ((~num) + 1));
            answer ++;
        }
        sb.append(answer).append("\n");
        System.out.println(sb);
    }
}
