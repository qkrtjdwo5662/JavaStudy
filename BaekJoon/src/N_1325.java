import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_1325 {

    static int n;
    static ArrayList<Integer>[] adjList;
    static int[] visited;
    static ArrayDeque<Integer> deque;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n+1];

        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[v].add(u);
        }

        int max = 0;
        visited = new int[n + 1];
        deque = new ArrayDeque<>();
        arr = new int[n + 1];

        for (int i = 1; i <= n ; i++) {
//            init();
            arr[i] = maxCount(i);
            if(max < arr[i]){
                max = arr[i];
            }
        }

        for (int i = 1; i <= n ; i++) {
            if(arr[i] == max){
                sb.append(i).append(" ");
            }
        }

        sb.append("\n");
        System.out.println(sb);

    }
//    static void init(){
//        for (int i =1; i <= n; i++){
//            visited[i] = 0;
//        }
//    }

    static int maxCount(int start){
        visited[start] = 1;
        deque.addLast(start);
        int count = 0;

        while(!deque.isEmpty()){
            int now = deque.pollFirst();
            visited[now] = 0;

            count ++;
            for (int i = 0; i < adjList[now].size(); i++) {
                int next = adjList[now].get(i);


                if(visited[next] == 0){
                    visited[next] = 1;
                    deque.addLast(next);

                }
            }
        }
        return count;

    }

}