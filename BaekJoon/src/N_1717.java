import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1717 {
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i = 0; i <= n ; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(operation == 0){
                union(u, v);
            }else if(operation == 1){
                if(find(u) == find(v)){
                    sb.append("YES").append("\n");
                }else sb.append("NO").append("\n");
            }
        }

        System.out.print(sb);
    }
    private static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        parent[x] = y;
    }
    private static int find(int a){
        if(parent[a] == a) {
            return a;
        }

        parent[a] = find(parent[a]);
        return parent[a];

    }
}
