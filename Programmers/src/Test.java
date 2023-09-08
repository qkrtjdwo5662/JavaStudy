
import java.io.IOException;


public class Test {
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        int n = 5;

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        parent[x] = y;
    }
    public static int find(int a){
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }
}
