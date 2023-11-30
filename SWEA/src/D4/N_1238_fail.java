package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_1238_fail {
    public static ArrayList<Integer> adjList[];
    public static ArrayList<Integer> list;
    public static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = 10;

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken()); // 데이터 길이
            int start = Integer.parseInt(st.nextToken()); // 시작점

            int[][] data = new int[length/2][2];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < length/2; j++) {
                for (int k = 0; k < 2; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    data[j][k] = num;
                }
            }


            adjList = new ArrayList[100+1];
            for (int j = 1; j <= 100 ; j++) {
                adjList[j] = new ArrayList<>();
            }

            for (int j = 0; j < length/2; j++) {
                int u = data[j][0];
                int v = data[j][1];

                adjList[u].add(v);
            }
            max = 0;
            bfs(start, 0);
            list = new ArrayList<>();
            bfs(start, 1);
            Collections.sort(list, Collections.reverseOrder());
            sb.append("#").append(i).append(" ").append(list.get(0)).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int start, int opr){
        boolean[] visited = new boolean[101];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        visited[start] = true;
        deque.addLast(start);
        int depth = -1;

        if(opr == 0){
            while (!deque.isEmpty()) {
                int size = deque.size();
                depth ++;
                for (int i = 0; i < size; i++) {
                    int now = deque.pollFirst();
                    for (int j = 0; j < adjList[now].size() ; j++) {
                        int next = adjList[now].get(i);

                        if(!visited[next]){
                            visited[next] = true;
                            deque.addLast(next);
                        }
                    }
                }
            }

            max = depth;
        }else if(opr == 1){
            while (!deque.isEmpty()) {
                int size = deque.size();
                depth ++;
                for (int i = 0; i < size; i++) {
                    int now = deque.pollFirst();

                    if(depth == max){
                        list.add(now);
                    }

                    for (int j = 0; j < adjList[now].size() ; j++) {
                        int next = adjList[now].get(i);

                        if(!visited[next]){
                            visited[next] = true;
                            deque.addLast(next);
                        }
                    }
                }
            }

            max = depth;
        }

    }
}
