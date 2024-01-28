import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int x = Integer.parseInt(st.nextToken());
        int answer = 0;
        for (int i = 0; i <= 8 ; i++) {
            if((x & (1 << i)) == (1 << i)){
                answer ++;
            }
        }

        sb.append(answer);
        System.out.println(answer);
    }
}
