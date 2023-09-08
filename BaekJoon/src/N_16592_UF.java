import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_16592_UF {
    public static int[] parent;
    public static int[] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        parent = new int[n+1];
        cost = new int[n+1];
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }

        int minSum = 0;
        for (int i = 1; i <= n ; i++) {
            if(find(0) != find(i)){
                minSum = minSum + cost[find(i)];
                union(0, i);
            }
        }

        if(minSum <= k) System.out.println(minSum);
        else System.out.println("Oh no");
    }
    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(cost[x] <= cost[y]){
            parent[y] = x;
        }else{
            parent[x] = y;
        }

    }
    public static int find(int a){
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }
}
