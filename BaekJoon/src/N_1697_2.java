import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_1697_2 {
    public static int end;
    public static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        if(start==end){
            System.out.println(0);
            return;
        }

        count = 0;
        bfs(start);
        System.out.println(count);
    }
    public static void bfs(int start){
        boolean[] visited = new boolean[100_001];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int answer =0;
        visited[start] = true;
        deque.addLast(start);

        while(!deque.isEmpty()){
            int size = deque.size();
            answer++;
            for (int i = 0; i < size; i++) {
                int now = deque.pollFirst();
                int next;
                for (int j = 0; j < 3; j++) {
                    if(j==0){
                        next = now - 1;
                    }else if(j==1){
                        next = now + 1;
                    }else{
                        next = now * 2;
                    }

                    if(next == end){
                        count = answer;
                        return;
                    }

                    if(next<0 || next>100000) continue;

                    if(!visited[next]){
                        visited[next] = true;
                        deque.addLast(next);
                    }
                }
            }
        }

    }
}
