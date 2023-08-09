import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 마을 수
        int m = Integer.parseInt(st.nextToken()); // 간선 수
        int x = Integer.parseInt(st.nextToken()); // target

        ArrayList<int[]>[] adjList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[u].add(new int[]{v,w});
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            boolean[] visited = new boolean[n+1];
            PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
                return Integer.compare(o1[1], o2[1]);
            }));
            int[] distGo = new int[n+1];
            int[] distCome = new int[n+1];
            Arrays.fill(distGo, 987654321);
            Arrays.fill(distCome, 987654321);

            distGo[i] = 0;
            pq.add(new int[]{i, 0});

            while(!pq.isEmpty()){
                int[] now = pq.poll();

                if(visited[now[0]]) continue;
                visited[now[0]] = true;

                for (int j = 0; j < adjList[now[0]].size(); j++) {
                    int[] next = adjList[now[0]].get(j);


                    if(distGo[next[0]] > distGo[now[0]] + next[1]){
                        distGo[next[0]] = distGo[now[0]] + next[1];
                        pq.add(new int[]{next[0], distGo[next[0]]});
                    }
                }
            }

            distCome[x] = 0;
            pq.add(new int[]{x, 0});
            Arrays.fill(visited, false);

            while(!pq.isEmpty()){
                int[] now = pq.poll();

                if(visited[now[0]]) continue;
                visited[now[0]] = true;
                for (int j = 0; j < adjList[now[0]].size(); j++) {
                    int[] next = adjList[now[0]].get(j);


                    if(distCome[next[0]] > distCome[now[0]] + next[1]){
                        distCome[next[0]] = distCome[now[0]] + next[1];
                        pq.add(new int[]{next[0], distCome[next[0]]});
                    }
                }
            }
            count = distGo[x] + distCome[i];
//            System.out.println(Arrays.toString(distGo));
//            System.out.println(Arrays.toString(distCome));
//            System.out.println();
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}
