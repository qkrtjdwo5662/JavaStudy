package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_1238 {
    public static ArrayList<Integer>[] adjList;
    public static ArrayList<Integer> list;
    public static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = 10;

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            int len = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            adjList = new ArrayList[101];
            for (int j = 1; j <= 100 ; j++) {
                adjList[j] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < len/2; j++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                adjList[from].add(to);
            }
            max = maxDepth(start);
            list = new ArrayList<>();
            bfs(start);
            Collections.sort(list, Collections.reverseOrder());
            sb.append("#").append(i).append(" ").append(list.get(0)).append("\n");

        }
        System.out.println(sb);
    }

    public static int maxDepth(int start){
        boolean[] visited = new boolean[101];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        visited[start] = true;
        deque.addLast(start);

        int depth = 0;
        while(!deque.isEmpty()){
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                int now = deque.pollFirst();
                for (int j = 0; j < adjList[now].size(); j++) {
                    int next = adjList[now].get(j);

                    if(!visited[next]){
                        visited[next] = true;
                        deque.addLast(next);
                    }
                }
            }
            depth ++;

        }
        return depth;

    }

    public static void bfs(int start){
        boolean[] visited = new boolean[101];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        visited[start] = true;
        deque.addLast(start);

        int depth = 0;
        while(!deque.isEmpty()){
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                int now = deque.pollFirst();
                if(depth== max-1 ){
                    list.add(now);
                }
                for (int j = 0; j < adjList[now].size(); j++) {
                    int next = adjList[now].get(j);

                    if(!visited[next]){
                        visited[next] = true;
                        deque.addLast(next);
                    }
                }
            }
            depth ++;

        }
    }
}
