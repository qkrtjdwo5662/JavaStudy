import java.util.Arrays;

public class MinimizeSalesDecline {
    public static int[] sales = {14, 17, 15, 18, 19, 14, 13, 16, 28, 17};
    public static int[][] links = {{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}};
    public static int[] parent;

    public static void main(String[] args) {
        System.out.println(solution(sales, links));
    }

    public static int solution(int[] sales, int[][] links){
        int answer = 0;
        int n = sales.length;
        parent = new int[n + 1];

        for (int i = 1; i <= n ; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < links.length; i++) {
            int a = links[i][0];
            int b = links[i][1];

            union(a, b);
            System.out.println(Arrays.toString(parent));
        }

//        System.out.println(Arrays.toString(parent));
        return answer;
    }

    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        parent[y] = x;
    }

    public static int find(int a){
        if(parent[a] == a){
            return parent[a];
        }

        return parent[a] = find(parent[a]);
    }
}
