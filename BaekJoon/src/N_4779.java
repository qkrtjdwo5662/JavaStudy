import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N_4779 {
    public static char[] c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String data;
        while((data= br.readLine()) != null){

            if(data.equals("")) break;

            int n = Integer.parseInt(data);
            if(n == 0) {
                sb.append("-").append("\n");
                continue;
            }
            c = new char[(int)Math.pow(3,n)];
            Arrays.fill(c, '-');
            recursive(n, 0, n, 0, (int)Math.pow(3, n));
            for (int i = 0; i < c.length; i++) {
                sb.append(c[i]);
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }

    public static void recursive(int n, int depth, int count, int start, int end){
        if(depth == count) {
            return;
        }

        for (int i = start + end/3; i < start + 2* (end/3); i++) {
            c[i] = ' ';
        }
        recursive(n/3, depth + 1, count, start, end/3);
        recursive(n/3, depth + 1, count, start + 2*(end/3), end/3);

    }
}
