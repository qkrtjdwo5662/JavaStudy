import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_1753_2 {
    public static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] adjList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 초기 시작 점
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 시작 점
            int v = Integer.parseInt(st.nextToken()); // 끝 점
            int w = Integer.parseInt(st.nextToken()); // 가중치

            adjList[u].add(new int[]{v,w}); // 방향 그래프
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);

        dist[start] = 0; // 초기 시작
        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()){
            int[] now = pq.poll(); // now[0]: 인접 정점 , now[1]: 인접 정점으로 가는데에 비용

            if(visited[now[0]]) continue;
            visited[now[0]] = true;

            for (int i = 0; i < adjList[now[0]].size(); i++) {
                if(dist[adjList[now[0]].get(i)[0]] > dist[now[0]] + adjList[now[0]].get(i)[1]) {
                    // 다음 정점의 거리 > 현재 정점의 거리 + 다음정점까지의 비용
                    dist[adjList[now[0]].get(i)[0]] = dist[now[0]] + adjList[now[0]].get(i)[1]; // 갱신
                    pq.add(new int[]{ adjList[now[0]].get(i)[0], dist[adjList[now[0]].get(i)[0]]}); // 정점, 누적 비용
                }
            }
        }

        for (int i = 1; i <=n ; i++) {
            if(dist[i] == INF) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.print(sb);
    }
}
