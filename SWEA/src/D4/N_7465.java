package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N_7465 {
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            parent = new int[n+1];

            for (int j = 1; j <= n ; j++) {
                parent[j] = j;
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            HashSet<Integer> set = new HashSet<>();
            for (int j = 1; j <= n ; j++) {
                set.add(find(j));
            }
            sb.append("#").append(i).append(" ").append(set.size()).append("\n");
        }
        System.out.println(sb);
    }
    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        parent[x] = y;
    }
    public static int find(int a){
        if(parent[a] == a){
            return parent[a];
        }

        return parent[a] = find(parent[a]);
    }
}
