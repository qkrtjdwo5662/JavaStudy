import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_1967_2 {
    static class Edge{
        int to;
        int weight;

        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    static int N;
    static ArrayList<Edge>[] adjList;
    static boolean[] visited;
    static int answer;
    static int maxNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb=  new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        if(N <= 1){
            sb.append(0).append("\n");
        }else{
            adjList = new ArrayList[N + 1];
            for (int i = 1; i <= N ; i++) {
                adjList[i] = new ArrayList<>();
            }


            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                adjList[a].add(new Edge(b, w));
                adjList[b].add(new Edge(a, w));
            }

            visited = new boolean[N + 1];
            answer = 0;
            maxNode = 0;
            go(1, 0);

            visited = new boolean[N + 1];
            answer = 0;
            go(maxNode, 0);

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

    }

    static void go(int now, int sum){
        if(visited[now]) return;
        visited[now] = true;

        for (int i = 0; i < adjList[now].size(); i++) {
            Edge edge = adjList[now].get(i);
            if(!visited[edge.to]){
                go(edge.to, sum + edge.weight);
            }else{
                if(sum > answer){
                    answer = sum;
                    maxNode = now;
                }
            }
        }
    }
}
