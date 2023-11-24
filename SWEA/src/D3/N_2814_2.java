package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_2814_2 {
    public static ArrayList<Integer>[] adjList;
    public static boolean[] visited;
    public static int answer;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            int m  = Integer.parseInt(st.nextToken());

            adjList = new ArrayList[n+1];

            for (int j = 1; j <= n ; j++) {
                adjList[j] = new ArrayList<>();
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                adjList[u].add(v);
                adjList[v].add(u);
            }

            answer = 0;
            for (int j = 1; j <= n ; j++) {
                visited = new boolean[n+1];
                visited[j] = true;
                dfs(j, 1);
            }

            sb.append("#").append(i).append(" ").append(answer).append("\n");

        }
        System.out.println(sb);
    }

    public static void dfs(int now, int depth){
        if(answer == n) return; // 이미 answer가 n이면 다 리턴

        if(depth == n){ // n에 도달하면 갱신
            answer = Math.max(answer, depth);
            return;
        }


        answer = Math.max(answer, depth);

        for (int i = 0; i < adjList[now].size(); i++) {
            int next = adjList[now].get(i);

            if(!visited[next]){
                visited[next] = true;
                dfs(next, depth+1);
                visited[next] = false;
            }
        }
    }
}

// dfs 반례
//1
//7 8
//1 2
//2 3
//2 4
//3 4
//3 7
//4 7
//4 5
//5 6
