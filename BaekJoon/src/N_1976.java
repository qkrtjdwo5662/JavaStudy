import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1976 {
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n ; j++) {
                int data = Integer.parseInt(st.nextToken());

                if(data == 1) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());

        int parentNode = -1;
        for (int i = 0; i < m; i++) {
            int node = Integer.parseInt(st.nextToken());

            if(i==0) parentNode = find(node);
            else{
                if(parentNode != find(node)) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
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
