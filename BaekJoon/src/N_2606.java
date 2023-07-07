import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] adjList = new ArrayList[n+1]; // 정점 개수
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) { // 입력 받아서 adjList 완성
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adjList[start].add(end);
            adjList[end].add(start);
        }

        boolean[] visited = new boolean[n+1];
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int count = 0;

        visited[1] = true;
        arrayDeque.add(1);

        while(!arrayDeque.isEmpty()){
            int now = arrayDeque.poll();
            for (int i = 0; i < adjList[now].size() ; i++) {
                if(!visited[adjList[now].get(i)]){
                    visited[adjList[now].get(i)] = true;
                    arrayDeque.add(adjList[now].get(i));
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
