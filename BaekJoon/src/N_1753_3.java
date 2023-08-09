import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_1753_3 {
    public static void main(String[] args) throws IOException {
        // 최단 거리를 갱신하여 짧은 경로를 발견한다. -> priority queue를 사용
        // 큐에서 꺼내면 방문처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] adjList = new ArrayList[n+1];

        for (int i = 1; i <=n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[u].add(new int[]{v,w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        }));

        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, 987654321);

        pq.add(new int[] {start,0});
        dist[start] = 0;

        while(!pq.isEmpty()){
            int[] now = pq.poll(); // 하나 꺼내고
            int point = now[0];

            if(visited[point]) continue;
            visited[point] = true; // 방문 표시

            for (int i = 0; i < adjList[point].size(); i++) { // 인접 정점을 탐색하는데
                if (dist[adjList[point].get(i)[0]] > dist[point] + adjList[point].get(i)[1]) { // 최소거리가 발견되면 갱신
                    dist[adjList[point].get(i)[0]] = dist[point] + adjList[point].get(i)[1];
                    pq.add(new int[]{adjList[point].get(i)[0], dist[adjList[point].get(i)[0]]});
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if(dist[i] != 987654321){
                sb.append(dist[i]).append("\n");
            }else{
                sb.append("INF").append("\n");
            }
        }
        System.out.print(sb);
    }
}
