import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_11724_bfs {
    public static boolean[] visited;
    public static ArrayList<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        adjList = new ArrayList[n+1]; // 1 ~ n
        visited = new boolean[n+1];

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

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int count = 0;


        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                visited[i] = true;
                arrayDeque.addLast(i);
                count++;
                while(!arrayDeque.isEmpty()){
                    int now = arrayDeque.pollFirst();
                    for (int j = 0; j < adjList[now].size(); j++) {
                        if(!visited[adjList[now].get(j)]){
                            visited[adjList[now].get(j)] = true;
                            arrayDeque.addLast(adjList[now].get(j));
                        }
                    }
                }
            }
        }


        System.out.println(count);
    }
}
