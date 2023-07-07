import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_24444_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adjList = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList[start].add(end);
            adjList[end].add(start);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList[i]);
        }

        boolean[] visited = new boolean[n+1];
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int[] answer = new int[n+1];

        visited[r] = true;
        arrayDeque.add(r);

        int count = 1;
        answer[r] = count;

        while(!arrayDeque.isEmpty()){
            int now = arrayDeque.poll();
            for (int i = 0; i < adjList[now].size(); i++) {
                if(!visited[adjList[now].get(i)]){
                    visited[adjList[now].get(i)] = true;
                    arrayDeque.add(adjList[now].get(i));
                    count++;
                    answer[adjList[now].get(i)] = count;
                }
            }
        }

        for (int i = 1; i <=n ; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.print(sb);
    }
}
