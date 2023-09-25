import java.util.Arrays;

public class UnionFind {
    public static int n = 5;
    public static int[] parent;
    public static void main(String[] args) {

        parent = new int[n+1];

        for (int i = 1; i <= n ; i++) {
            parent[i] = i;
        }

        union(1,2);
        System.out.println(Arrays.toString(parent));
        System.out.println(find(1));
        union(4, 3);
        union(5, 3);
        System.out.println(Arrays.toString(parent));


    }

    public static void union(int a, int b){
        int x = parent[a];
        int y = parent[b];

        parent[x] = y;
    }
    public static int find(int a){ // 부모 노드를 찾기
        if(parent[a] == a) return parent[a];

        return parent[a] = find(parent[a]);
    }
}
