package D4;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class N_1251 {

    public static int[] parents;
    public static Point[] islands;
    public static class Edge{
        int a;
        int b;
        double cost;

        public Edge(int a, int b, double cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

    }

    public static ArrayList<Edge> edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 섬의 개수

            parents = new int[n+1];

            for (int j = 1; j <= n ; j++) {
                parents[j] = j;
            }
            islands = new Point[n+1];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) { // x좌표
                int x = Integer.parseInt(st.nextToken());
                islands[j] = new Point(0, 0);
                islands[j].x = x;
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) { // y죄료
                int y = Integer.parseInt(st.nextToken());
                islands[j].y = y;
            }

            st = new StringTokenizer(br.readLine());
            double e = Double.parseDouble(st.nextToken());

            edges = new ArrayList<>();
            for (int j = 1; j <= n-1 ; j++) {
                for (int k = j+1; k <= n ; k++) {
                    int a = j;
                    int b = k;
                    double cost = (Math.pow(Math.abs(islands[j].x - islands[k].x), 2) + Math.pow(Math.abs(islands[j].y - islands[k].y), 2) ) * e;

                    Edge edge = new Edge(a, b, cost);
                    edges.add(edge);
                }
            }

            Collections.sort(edges, (o1, o2) -> {
                return Double.compare(o1.cost, o2.cost);
            });

            double answer = 0;
            for (int j = 0; j < edges.size(); j++) {
                Edge edge = edges.get(j);
                int a = edge.a;
                int b = edge.b;
                double cost = edge.cost;

                if(find(a) != find(b)){
                    union(a, b);
                    answer += cost;
                }
            }


            sb.append("#").append(i).append(" ").append(Math.round(answer)).append("\n");
        }
        System.out.println(sb);
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
