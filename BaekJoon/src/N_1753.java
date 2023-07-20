import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수

        ArrayList<int[]>[] adjList = new ArrayList[n+1];
        for (int i = 1; i <=n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 시작 정점
            int v = Integer.parseInt(st.nextToken()); // 끝 정점
            int w = Integer.parseInt(st.nextToken()); // 가중치

            adjList[u].add(new int[]{v, w});
        }

        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        int INF = 987654321; // 무한대
        Arrays.fill(dist, INF); // 무한대로 채워넣기

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });

        dist[start] = 0;
        pq.add(new int[]{start, 0}); // 시작점 1, 1부터 1까지의 거리 0

        while(!pq.isEmpty()){
            int[] now = pq.poll(); // 끝 정점, 가중치

            if(visited[now[0]]) continue; // 방문했으면 continue
            visited[now[0]] = true; // 안했으면 true 표시

            for (int i = 0; i < adjList[now[0]].size(); i++) {
                if(dist[adjList[now[0]].get(i)[0]] > now[1] +  adjList[now[0]].get(i)[1]){
                    dist[adjList[now[0]].get(i)[0]] = now[1] +  adjList[now[0]].get(i)[1];
                    pq.add(new int[]{adjList[now[0]].get(i)[0], dist[adjList[now[0]].get(i)[0]]}); // 다음 끝점, 다음 끝점의 가중치
                }
            }

        }

        for (int i = 1; i < dist.length; i++) {
            if(dist[i] == INF) {
                sb.append("INF").append("\n");
            }else sb.append(dist[i]).append("\n");
        }
        System.out.print(sb);
    }
}
