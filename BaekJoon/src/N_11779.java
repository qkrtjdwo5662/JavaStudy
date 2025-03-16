import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_11779 {
    static int n;
    static int m;
    static final int INF = 987654321;
    static List<Integer> list;

    static List<Node>[] adjList;

    static int[] dist;
    static int[] from;
    static class Node{
        int to;
        int weight;
        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        adjList = new List[n + 1];

        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[u].add(new Node(v, w));
//            adjList[v].add(new Node(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        dijkstra(s, e);
        // 해당 목표 지점까지 가기 위한 최단 경로
        sb.append(dist[e]).append("\n"); // 목표지점까지의 최소 비용
        sb.append(list.size()).append("\n");
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }
        sb.append("\n");
        System.out.println(sb);
    }

    static void dijkstra(int s, int e){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.weight, o2.weight);
        });
        dist = new int[n + 1];
        from = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[s] = 0;
        pq.add(new Node(s, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(now.to == e) break;

            for (int i = 0; i < adjList[now.to].size(); i++) {
                Node next = adjList[now.to].get(i);

                if(dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                    from[next.to] = now.to; // next.to는 now.to로 부터 왔음
                }
            }
        }

        while(e != s){
            list.add(e);
            e = from[e];
        }
        list.add(s);

    }
}
