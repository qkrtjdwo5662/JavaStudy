package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N_3752_fail {
    public static int n;
    public static int[] scores;
    public static HashSet<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());

            scores = new int[n];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int score = Integer.parseInt(st.nextToken());
                scores[j] = score;
            }
            set = new HashSet<>();
            dfs(0, 0);
            sb.append(set).append("\n");
            sb.append("#").append(i).append(" ").append(set.size()).append("\n");

        }

        System.out.println(sb);
    }

    public static void dfs(int depth, int sum){
        if(depth == n){
            set.add(sum);
            return;
        }

        dfs(depth+1, sum + scores[depth]);
        dfs(depth+1, sum);

    }
}
