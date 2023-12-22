import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test777 {
    public static int n;
    public static int[] answer;
    public static ArrayList<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb =new StringBuilder();

        n = Integer.parseInt(st.nextToken()); // 정점의 수
        int m = Integer.parseInt(st.nextToken()); // 간선의 수
        int start = Integer.parseInt(st.nextToken()); // 시작 정점


        adjList =new ArrayList[n+1];
        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }
        // 인접 리스트 완성

        for (int i = 1; i <= n ; i++) {
            Collections.sort(adjList[i]);
        }
        // 오름차순 정렬

        answer = new int[n+1];
        bfs(start);

        for (int i = 1; i <= n ; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);

    }

    public static void bfs(int start){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        int count = 1;

        // 시작점 큐에 넣는다.
        deque.addLast(start);
        // 시작점 방문처리 해준다.
        visited[start] = true;

        // 꺼낸다
        while(!deque.isEmpty()){
            int now = deque.pollFirst(); // 하나 꺼냄
            answer[now] = count;
            count++;
//            System.out.println("now : " + now);
            //큐에서 꺼낸 정점의 인접 정점을 확인한다.
            for (int i = 0; i < adjList[now].size(); i++) {
                int next = adjList[now].get(i);

                //해당 인접 정점의 방문 여부를 확인한다.
                if(!visited[next]){
                    //방문하지 않은 정점을 방문처리 하고 큐에 넣는다.
                    visited[next] = true;
                    deque.addLast(next);
//                    System.out.println("next : " + next);
                }
            }
        }
    }
}
