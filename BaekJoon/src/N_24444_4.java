import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N_24444_4 {
    public static int n;
    public static ArrayList<Integer>[] adjList;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 간선의 수
        int start = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n+1];

        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList[i]);
        }

        int[] answer = new int[n+1];

        bfs(start, answer);
        for (int i = 1; i <= n ; i++) {
            sb.append(answer[i]).append("\n");
        }

        System.out.println(sb);

    }

    public static void bfs(int start, int[] answer){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        int order = 1;

        deque.addLast(start);
        visited[start] = true;

        while(!deque.isEmpty()){
            int now = deque.pollFirst();

            answer[now] = order;
            order ++;
            for (int i = 0; i < adjList[now].size(); i++) {
                int next = adjList[now].get(i);

                if(!visited[next]){
                    visited[next] = true;
                    deque.addLast(next);
                }
            }
        }

    }
}
