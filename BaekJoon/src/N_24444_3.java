import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N_24444_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adjList = new ArrayList[n+1];
        for (int i = 1; i <=n ; i++) {
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

        boolean[] visited = new boolean[n+1];
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int[] answer = new int[n+1];
        int count = 1;

        visited[start] = true;
        arrayDeque.addLast(start);
        answer[start] = count;
        count++;

        while(!arrayDeque.isEmpty()){
            int now = arrayDeque.pollFirst();
            for(int i=0; i < adjList[now].size(); i++){
                if(!visited[adjList[now].get(i)]){
                    visited[adjList[now].get(i)] = true;
                    arrayDeque.addLast(adjList[now].get(i));
                    answer[adjList[now].get(i)] = count;
                    count++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.print(sb);
    }
}
