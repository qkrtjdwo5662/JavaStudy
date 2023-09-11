import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 문서의 개수
            int m = Integer.parseInt(st.nextToken()); // 찾고자 하는 인덱스

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            ArrayDeque<int[]> deque = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int importance = Integer.parseInt(st.nextToken()); // 중요도
                pq.add(importance);
                deque.addLast(new int[]{importance, j});
            }
            int count = 0;
            while(!pq.isEmpty()){
                int pqPoll = pq.poll();
                int[] now ={-1, -1};
//                System.out.println(pqPoll);
                while(!deque.isEmpty()){
                    now = deque.pollFirst();

                    if(now[0] == pqPoll) {
                        count ++;
//                        System.out.println(now[0] + " " + now[1]);
                        break;
                    }
                    else deque.addLast(now);
                }

                if(m == now[1]) {
                    sb.append(count).append("\n");
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}
