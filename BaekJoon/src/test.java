public class test{
    public static int[] parent;
    public static int n= 7;
    public static void main(String[] args) {
        parent = new int[n+1]; // 1 ~ 7

        for (int i = 1; i <= n; i++) {
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
