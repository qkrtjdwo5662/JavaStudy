import java.util.HashMap;

public class PowerGrid_4 {
    public static int n = 9;
    public static int[][] wires = {{1,3}, {2,3},{3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}};

    public static int[] parent;
    public static void main(String[] args) {
        System.out.println(solution(n, wires));
    }

    public static int solution(int n, int[][] wires){
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            parent = new int[n+1];
            for (int j = 1; j <= n ; j++) {
                parent[j] = j;
            }

            for (int j = 0; j < wires.length; j++) {
                if(i==j) continue;
                int u = wires[j][0];
                int v = wires[j][1];

                union(u, v);
            }

            HashMap<Integer, Integer> map =new HashMap<>();

            for (int j = 1; j <= n ; j++) {
                if(map.containsKey(find(j))){
                    map.put(find(j), map.get(find(j))+1);
                    continue;
                }
                map.put(find(j), 1);
            }
            int maxKey = 0;
            int max = 0;

            int minKey = 0;
            int min = 0;
            for (int key : map.keySet()) {
                if(max < map.get(key)){
                    max = map.get(key);
                    maxKey = key;
                }
            }
            for (int key : map.keySet()) {
                if(key != maxKey){
                    minKey = key;
                    min = map.get(key);
                }
            }

            answer = Math.min(answer, max-min);
        }
        return answer;
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
