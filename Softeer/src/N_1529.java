import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_1529 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수

        ArrayList<Integer>[] adjList = new ArrayList[n+1];

        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 시작
        int end = Integer.parseInt(st.nextToken()); // 끝

        boolean[] visited_fe = new boolean[n+1]; // 방문체크
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        visited_fe[start] = true;
        arrayDeque.addLast(start);

        while(!arrayDeque.isEmpty()){
            int now = arrayDeque.pollFirst();
            if(now == end) continue;
            for (int i = 0; i < adjList[now].size(); i++) {
                if(!visited_fe[adjList[now].get(i)]){
                    visited_fe[adjList[now].get(i)] = true;
                    arrayDeque.addLast(adjList[now].get(i));
                }
            }
        }

        boolean[] visited_ef = new boolean[n+1];
        arrayDeque = new ArrayDeque<>();

        visited_ef[end] = true;
        arrayDeque.addLast(end);

        while(!arrayDeque.isEmpty()){
            int now = arrayDeque.pollFirst();
            if(now == start) continue;
            for (int i = 0; i < adjList[now].size(); i++) {
                if(!visited_ef[adjList[now].get(i)]){
                    visited_ef[adjList[now].get(i)] = true;
                    arrayDeque.addLast(adjList[now].get(i));
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if(i==start || i==end){
                continue;
            }

            if(visited_fe[i] && visited_ef[i]) answer++;
        }

        System.out.print(answer);

    }
}
