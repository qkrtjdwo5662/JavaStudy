package D4;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N_1494_fail {
    public static int[] parent;
    public static Point[] earthWorm;
    public static class Edge{
        int a;
        int b;
        long cost;

        public Edge(int a, int b, long cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            parent = new int[n+1];

            for (int j = 1; j <= n ; j++) {
                parent[j] = j;
            }
            earthWorm = new Point[n+1];

            for (int j = 1; j <= n ; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                earthWorm[j] = new Point(0, 0);
                earthWorm[j].x = x;
                earthWorm[j].y = y;
            }

            ArrayList<Edge> edges = new ArrayList<>();
            for (int j = 1; j < n ; j++) {
                for (int k = j+1; k <= n ; k++) {
                    int a = j;
                    int b = k;
                    long cost = (long) (Math.pow(Math.abs(earthWorm[j].x - earthWorm[k].x), 2) + Math.pow(Math.abs(earthWorm[j].y - earthWorm[k].y), 2));

                    Edge edge = new Edge(a, b, cost);
                    edges.add(edge);
                }
            }

            Collections.sort(edges, (o1, o2) -> {
                return Long.compare(o1.cost, o2.cost);
            });
            long answer = 0;
            for (int j = 0; j < edges.size(); j++) {
                int a = edges.get(j).a;
                int b = edges.get(j).b;
                long cost = edges.get(j).cost;

                if(find(a) != find(b)){
                    union(a, b);
                    answer += cost;
                }
            }

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        parent[x] = y;
    }

    public static int find(int a){
        if(parent[a] == a){
            return parent[a];
        }

        return parent[a] = find(parent[a]);
    }
}
