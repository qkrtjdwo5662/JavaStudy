package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_1248 {
    public static HashSet<Integer> parentList;
    public static ArrayList<Integer>[] nodeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 정점의 개수
            int e = Integer.parseInt(st.nextToken()); // 간선의 개수

            int v1 = Integer.parseInt(st.nextToken()); // 정점 1
            int v2 = Integer.parseInt(st.nextToken()); // 정점 2

            nodeList = new ArrayList[n+1];
            for (int j = 1; j <= n ; j++) {
                nodeList[j] = new ArrayList<>();
            }

            int[] parents = new int[n+1];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < e; j++) {
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                nodeList[parent].add(child);
                parents[child] = parent;
            }

            parentList = new HashSet<>();
            int common = findParent(v1, v2, parents);
            boolean[] visited = new boolean[n+1];

            int answer = bfs(common, visited);
            sb.append("#").append(i).append(" ").append(common).append(" ").append(answer).append("\n");

        }
        System.out.println(sb);

    }
    public static int bfs(int start, boolean[] visited){
        int count = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        visited[start] = true;

        deque.addLast(start);

        while(!deque.isEmpty()){
            int now = deque.pollFirst();
            count++;

            for (int i = 0; i < nodeList[now].size(); i++) {
                int next = nodeList[now].get(i);

                if(!visited[next]){
                    visited[next] = true;
                    deque.addLast(next);
                }
            }
        }

        return count;
    }

    public static int findParent(int v1, int v2, int[] parents){
        parentList = new HashSet<>();

        while(v1 != 0){
            v1 = parents[v1];
            parentList.add(v1);
        }

        while (v2 != 0){
            v2 = parents[v2];
            if(parentList.contains(v2)){
                return v2;
            }
        }

        return 1;
    }


}
