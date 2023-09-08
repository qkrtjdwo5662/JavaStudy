import java.util.ArrayList;

public class NetWork_UF {
    public static int n = 3;
    public static int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

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
                if(i==j) continue;

                if(computers[i][j] == 1){
                    union(i, j);
                }
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(!arrayList.contains(find(i))){
                arrayList.add(find(i));
            }
        }
        return arrayList.size();
    }
    private static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        parent[x] = y;

    }
    private static int find(int a){
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }
}
