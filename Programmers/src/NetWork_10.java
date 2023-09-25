import java.util.HashSet;

public class NetWork_10 {
    public static int[][] computers = {{1,1,0}, {1,1,1}, {0,1,1}};
    public static int n = 3;
    public static int[] parent;
    public static void main(String[] args) {
        System.out.println(solution(n, computers));
    }
    public static int solution(int n, int[][] computers){

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if(computers[i][j] == 1){
                    union(i, j);
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(i));
        }


        return set.size();
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
