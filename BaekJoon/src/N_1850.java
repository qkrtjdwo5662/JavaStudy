import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long g = gcd(a, b);

        for (long i = 0; i < g; i++) {
            sb.append(1);
        }

        System.out.println(sb);
    }

    public static long gcd(long a, long b){
        long r = a%b;
        if(r==0) return b;
        else return gcd(b, r);
    }
}
