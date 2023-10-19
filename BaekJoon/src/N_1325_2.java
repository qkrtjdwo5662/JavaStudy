import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1325_2 {
    public static ArrayList<Integer>[] adjList;
    public static boolean[] visited;
    public static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb =new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n+1];

        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
        }

        answer = new int[n+1];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n ; i++) {
            visited = new boolean[n+1];
            bfs(i);
            min = Math.min(min, answer[i]);
        }
        for (int i = 1; i <= n ; i++) {
            if(answer[i] == min) sb.append(i).append(" ");
        }

        System.out.println(sb);
//        System.out.println(Arrays.toString(answer));
    }

    public static void bfs(int start){
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        visited[start] = true;
        deque.addLast(start);

        while(!deque.isEmpty()){
            int now = deque.pollFirst();
            answer[now]++;
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
