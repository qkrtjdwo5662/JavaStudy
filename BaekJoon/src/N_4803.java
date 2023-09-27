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
    public static boolean flag;
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
            }

            visited = new boolean[n+1];
            int t = 0;
            flag = false;
            sb.append("Case ").append(tc).append(": ");
            for (int i = 1; i <= n ; i++) {
                if(!visited[i] && !flag){
                    bfs(i);
                    t++;
                }
            }

            if(flag) continue;
            else{
                if(t == 1) sb.append("There is one tree.").append("\n");
                else sb.append("A forest of ").append(t).append(" trees.").append("\n");
            }

        }

    }

    public static void bfs(int start){
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        visited[start] = true;
        deque.addLast(start);

        while(!deque.isEmpty()){
            int now = deque.pollFirst();

            for (int i = 0; i < arrayList[now].size(); i++) {
                int next = arrayList[now].get(i);

                if(!visited[next]){
                    visited[next] = true;
                    deque.add(next);
                }else{
                    sb.append("No trees.").append("\n");
                    flag = true;
                    return;
                }
            }
        }
    }
}
