import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_1766 {
    static class Solve{
        int num;
        int depth;

        public Solve(int num, int depth){
            this.num = num;
            this.depth = depth;
        }
    }
//    static PriorityQueue<Solve> pq;
    static PriorityQueue<Integer> pq;
    static ArrayDeque<Integer> deque;
    static boolean[] visited;
    static int[] parent;
    static List<Integer>[] adjList;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 문제의 수
        int m = Integer.parseInt(st.nextToken()); // 문제의 정보

        adjList = new List[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            parent[b] = a;
            // a가 b보다 문제가 쉬움
            adjList[a].add(b);
        }

//        pq = new PriorityQueue<>((o1, o2 ) -> {
//            if(o1.depth == o2.depth){
//                return Integer.compare(o1.num, o2.num);
//            }else return Integer.compare(o1.depth, o2.depth);
//        });
        pq = new PriorityQueue<>();
        deque = new ArrayDeque<>();
        visited = new boolean[n + 1];

        System.out.println(Arrays.toString(parent));
        for (int i = 1; i <= n ; i++) {
            if(!visited[i] && parent[i] == i){
                dfs(0, i);
            }
        }

        for (int i = 1; i <= n ; i++) {
            if(!visited[i]){
                dfs(0, i);
            }
        }

        while(!pq.isEmpty()){
            int num = pq.poll();

            sb.append(num).append(" ");
        }

        System.out.println(sb);

    }

    static void dfs(int depth, int now){
        if(visited[now]) {
            while(!pq.isEmpty()){
                int num = pq.poll();

                sb.append(num).append(" ");
            }
            return;
        }
        visited[now] = true;

        pq.add(now);
        for (int i = 0; i < adjList[now].size(); i++) {
            int next = adjList[now].get(i);
            if(!visited[next]){
                dfs(depth + 1, next);
            }
        }
    }
}
