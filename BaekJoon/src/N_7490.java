import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_7490 {
    public static StringBuilder sb;
    public static int n;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < tc; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = j+1;
            }
            dfs(1, "1");
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void dfs(int depth, String s){
        if(depth == n){
            int sum = 0;
            String s1 = s.replaceAll(" ", "");
            StringTokenizer st = new StringTokenizer(s1, "-|+", true);
            sum = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                String op = st.nextToken();
                if(op.equals("+")){
                    sum = sum + Integer.parseInt(st.nextToken());
                }else{
                    sum = sum - Integer.parseInt(st.nextToken());
                }
            }

            if(sum == 0) sb.append(s).append("\n");
            return;
        }
        dfs(depth + 1, s+" "+arr[depth]);
        dfs(depth + 1, s+"+"+arr[depth]);
        dfs(depth + 1, s+"-"+arr[depth]);

    }
}
