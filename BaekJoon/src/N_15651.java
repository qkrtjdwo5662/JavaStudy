import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_15651 {
    public static int n;
    public static int m;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        backtrack(0, "");
        System.out.print(sb);
    }

    public static void backtrack(int depth, String s){
        if(depth == m){
            sb.append(s).append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(depth!=0)backtrack(depth+1, s+" "+i);
            else backtrack(depth+1, s+i);
        }
    }
}
