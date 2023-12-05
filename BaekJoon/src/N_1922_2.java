import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1922_2 {
    public static int[] parents;
    public static int[][] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        parents = new int[n+1];

        for (int i = 1; i <= n ; i++) {
            parents[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        edges = new int[m][3];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[i][0] = a;
            edges[i][1] = b;
            edges[i][2] = cost;
        }

        Arrays.sort(edges, (o1, o2) -> {
            return Integer.compare(o1[2], o2[2]);
        });

        System.out.println(kruskal());
    }

    public static int kruskal(){
        int answer = 0;
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int cost = edges[i][2];

            if(find(a) != find(b)){
                union(a, b);
                answer += cost;
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
            return parents[a];
        }

        return parents[a] = find(parents[a]);
    }
}
