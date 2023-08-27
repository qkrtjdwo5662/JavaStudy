import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_1389 {
    public static ArrayList<Integer>[] adjList;
    public static boolean[] visited;
//    public static int count;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;
        int sum = 0;
        adjList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
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
            sum = 0;
            for (int j = 1; j <= n; j++) {
                if(i==j) continue;

                sum = sum + bfs(i,j);
            }
//            System.out.println(sum);
            answer = Math.min(answer, sum);
        }


        for (int i = 1; i <= n; i++) {
            sum = 0;
            for (int j = 1; j <= n; j++) {
                if(i==j) continue;

                sum = sum + bfs(i,j);
            }
            if(answer == sum) {
                System.out.println(i);
                return;
            }
        }
    }

    public static int bfs(int start, int target){
        visited = new boolean[n+1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int count = 0;

        visited[start] = true;
        deque.addLast(start);

        int size = deque.size();
        while(!deque.isEmpty()){
            size = deque.size();
            count++;
            for (int i = 0; i < size; i++) {
                int now = deque.pollFirst();

                for (int j = 0; j < adjList[now].size(); j++) {
                    int next = adjList[now].get(j);

                    if(next == target) return count;

                    if(!visited[next]){
                        visited[next] = true;
                        deque.addLast(next);
                    }
                }
            }
        }

        return count;
    }
}
