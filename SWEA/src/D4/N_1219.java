package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_1219 {
    public static ArrayList<Integer>[] adjList;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = 10;

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            adjList = new ArrayList[100];
            for (int j = 0; j < 100; j++) {
                adjList[j] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adjList[u].add(v);
            }
            visited = new boolean[100];
            dfs(0);
            if(visited[99]){
                sb.append("#").append(i).append(" ").append(1).append("\n");
            }else sb.append("#").append(i).append(" ").append(0).append("\n");

//            sb.append("#").append(i).append(" ").append(bfs(0)).append("\n");
        }
        System.out.println(sb);
    }

//    public static int bfs(int start){
//        boolean[] visited = new boolean[100];
//        ArrayDeque<Integer> deque = new ArrayDeque<>();
//
//        visited[start] = true;
//        deque.addLast(start);
//
//        while(!deque.isEmpty()){
//            int now = deque.pollFirst();
//
//            for (int i = 0; i < adjList[now].size(); i++) {
//                int next = adjList[now].get(i);
//
//                if(!visited[next]){
//                    visited[next] = true;
//                    deque.addLast(next);
//                }
//            }
//        }
//
//        if(visited[99]) return 1;
//        else return 0;
//    }

    public static void dfs(int now){
        if(visited[99]) return;

        if(visited[now]) return;

        visited[now] = true;

        for (int i = 0; i < adjList[now].size(); i++) {
            int next = adjList[now].get(i);

            dfs(next);
        }
    }
}
