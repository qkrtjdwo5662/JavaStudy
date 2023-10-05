import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N_11724_uf {
    public static int[] parent;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            union(u, v);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(find(i));
        }

        System.out.println(set.size());
    }
    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        parent[x] = y;
    }


    public static int find(int a){
        if(parent[a] == a) return parent[a];

        return parent[a] = find(parent[a]);
    }
}
