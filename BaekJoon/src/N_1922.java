import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1922 {
    public static class Edge{
        int a;
        int b;
        int cost;

        public Edge(int a, int b, int cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    public static Edge[] edges;
    public static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        parents = new int[n+1];

        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, cost);
        }
        System.out.println(kruskal());
    }

    public static int kruskal(){
        Arrays.sort(edges, (o1, o2) -> {
            return Integer.compare(o1.cost, o2.cost);
        });

        int answer = 0;
        for (Edge edge : edges) {
            if(find(edge.a) != find(edge.b)){
                union(edge.a, edge.b);
                answer += edge.cost;
            }
        }

        return answer;
    }

    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        parents[x] = y;
    }

    public static int find(int a){
        if(parents[a] == a){
            return a;
        }

        return parents[a] = find(parents[a]);
    }
}
