import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_1325 {
    public static ArrayList<Integer>[] adjList;
    public static int[] answer;
    public static boolean[] visited;
    public static int count;
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
        int max = 0;
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n+1];
            count = 0;
            visited[i] = true;
            dfs(i);

            answer[i] = count;
            max = Math.max(max, count);
        }



        for (int i = 1; i <= n ; i++) {
            if(answer[i] == max) sb.append(i).append(" ");
        }


        System.out.println(sb);
        
    }

    public static void dfs(int now){
        count++;

        for (int i = 0; i < adjList[now].size(); i++) {
            int next = adjList[now].get(i);
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
            }
        }

    }
}
