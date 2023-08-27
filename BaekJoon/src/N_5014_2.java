import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_5014_2 {
    public static int f;
    public static int s;
    public static int g;
    public static int u;
    public static int d;
    public static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken()); // 전체
        s = Integer.parseInt(st.nextToken()); // 시작
        g = Integer.parseInt(st.nextToken()); // 목표
        u = Integer.parseInt(st.nextToken()); // 위로
        d = Integer.parseInt(st.nextToken()); // 아래로
        count = 0;

        if(s==g){
            System.out.println(0);
            return;
        }
        bfs(s);

        if(count == 0) System.out.println("use the stairs");
        else System.out.println(count);
    }

    public static void bfs(int start){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[f+1];

        deque.addLast(start);
        visited[start] = true;

        int answer = 0;
        int size = deque.size();
        while(!deque.isEmpty()){
            size = deque.size();
            answer++;
            for (int i = 0; i < size; i++) {
                int now = deque.pollFirst();
                int next = 0;
                for (int j = 0; j < 2; j++) {
                    if(j==0){
                        next = now + u;
                    }else{
                        next = now - d;
                    }

                    if(next == g){
                        count = answer;
                        return;
                    }

                    if(next < 1 || next > f) continue;

                    if(!visited[next]){
                        visited[next] = true;
                        deque.addLast(next);
                    }

                }

            }
        }




    }
}
