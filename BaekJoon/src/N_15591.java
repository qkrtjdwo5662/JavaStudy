import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_15591 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] adjList = new ArrayList[n+1];
        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            adjList[u].add(new int[]{v, r});
            adjList[v].add(new int[]{u, r});
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[n+1];
            visited[v] = true;
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            deque.addLast(v);

            int answer= 0;
            while(!deque.isEmpty()){
                int now = deque.pollFirst();

                for (int j = 0; j < adjList[now].size(); j++) {
                    int next = adjList[now].get(j)[0];
                    int distance = adjList[now].get(j)[1];

                    if(!visited[next] && distance>= k){
                        deque.add(next);
                        visited[next] = true;
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
