import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_5014 {
    public static int f;
    public static int g;
    public static int u;
    public static int d;
    public static int count = 0;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken()); // 총 층수
        int s = Integer.parseInt(st.nextToken()); // 출발 층
        g = Integer.parseInt(st.nextToken()); // 목표 층
        u = Integer.parseInt(st.nextToken()); // 위로 버튼 층
        d = Integer.parseInt(st.nextToken()); // 아래로 버튼 층

        visited = new boolean[f+1];
        bfs(s);


//        if(count == 0) System.out.println("use the stairs");
//        else System.out.println(count);

    }

    public static void dfs(int now, int depth){
        if(now<1 || now>f) return;

        if(visited[now]) return;
        visited[now] = true;

        if(now == g){
            count=depth;
        }

        dfs(now+u, depth+1);
        dfs(now-d, depth+1);
    }

    public static void bfs(int start){
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.addLast(start);
        visited[start] = true;

        while(!deque.isEmpty()) {

            int now = deque.pollFirst();
            int next = 0;
            System.out.println(now);
            count++;
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    next = now + u;
                } else {
                    next = now - d;
                }

                if (next == g) {
                    System.out.println("next" + next);
                    return;
                }

                if (next < 1 || next > f) {
//                    System.out.println("out" + next);
                    return;
                }


                if (!visited[next]) {
                    visited[next] = true;
                    deque.addLast(next);
                    System.out.println(next);
                }

                System.out.println(deque);
            }

        }
    }
}
