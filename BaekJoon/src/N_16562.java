import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_16562 {
    public static boolean[] visited;
    public static ArrayList<Integer>[] adjList;
    public static int[] cost;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 학생 수
        int m = Integer.parseInt(st.nextToken()); // 관계 수
        int k = Integer.parseInt(st.nextToken()); // 가진 돈

        cost = new int[n+1];
        adjList = new ArrayList[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n ; i++) {

            cost[i] = Integer.parseInt(st.nextToken());
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }

        visited = new boolean[n+1];
        answer = 0;

        for (int i = 1; i <= n ; i++) {
            if(!visited[i]){
                answer = answer + bfs(i);
            }
        }

        if(answer<=k) System.out.println(answer);
        else System.out.println("Oh no");
    }

    public static int bfs(int start){
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.addLast(start);
        visited[start] = true;
        int budget = cost[start];

        while(!deque.isEmpty()){
            int now = deque.pollFirst();

            for (int i = 0; i < adjList[now].size(); i++) {
                int next = adjList[now].get(i);

                if(!visited[next]){
                    visited[next] = true;
                    deque.addLast(next);
                    budget = Math.min(budget, cost[next]);
                }
            }
        }

        return budget;
    }
}
