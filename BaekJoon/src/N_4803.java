import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_4803 {
    public static ArrayList<Integer>[] arrayList;
    public static boolean[] visited;
    public static StringBuilder sb;
    public static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        int tc =0;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0){
                System.out.print(sb);
                return;
            }

            tc = tc +1;
            arrayList = new ArrayList[n+1];
            for (int i = 1; i <= n ; i++) {
                arrayList[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                arrayList[u].add(v);
                arrayList[v].add(u);
            }

            visited = new boolean[n+1];
            check = new boolean[n+1][n+1];
            int t = 0;
            sb.append("Case ").append(tc).append(": ");
            for (int i = 1; i <= n ; i++) {
                if(!visited[i]){
                    t = t + bfs(i);
                }
            }


            if(t == 0) sb.append("No trees.").append("\n");
            else if(t==1) sb.append("There is one tree.").append("\n");
            else sb.append("A forest of ").append(t).append(" trees.").append("\n");


        }

    }

    public static int bfs(int start){
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        visited[start] = true;
        deque.addLast(start);
        int node = 0;
        int edge = 0;
        while(!deque.isEmpty()){
            int now = deque.pollFirst();
            node = node + 1;
            for (int i = 0; i < arrayList[now].size(); i++) {
                int next = arrayList[now].get(i);
                edge = edge + 1;
                if(visited[next]){
                    if(!check[now][next]) return 0;
                }else{
                    visited[next] = true;
                    deque.add(next);
                    check[now][next] = true;
                    check[next][now] = true;
                }
            }
        }
        return 1;
    }
}
