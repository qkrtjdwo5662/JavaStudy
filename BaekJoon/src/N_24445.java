import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_24445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n+1];
        int[] answer = new int[n+1];
        int count = 1;
        ArrayList<Integer>[] arrayList = new ArrayList[n+1]; // 1~5 0은 무시
        for (int i = 1; i <= n; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());

            arrayList[startNode].add(endNode);
            arrayList[endNode].add(startNode);
        }

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        visited[start] = true;
        arrayDeque.add(start);
        answer[start] = count;

        while(!arrayDeque.isEmpty()){
            int now = arrayDeque.pollFirst(); // 꺼내서
            for (int i = 0; i < arrayList[now].size(); i++) { // 연결 노드 탐색
                pq.add(arrayList[now].get(i)); // pq에 넣어주고
            }
            while (!pq.isEmpty()){ // 내림차순 으로 연결노드 탐색
                int peek = pq.poll(); // 내림차순 순으로 뽑고
                for (int i = 0; i < arrayList[now].size(); i++) {
                    if(peek == arrayList[now].get(i)){ // 같으면
                        if(!visited[arrayList[now].get(i)]){
                            visited[arrayList[now].get(i)] = true;
                            arrayDeque.add(arrayList[now].get(i));
                            count++;
                            answer[arrayList[now].get(i)] = count;
                        }
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.print(sb);
    }
}
