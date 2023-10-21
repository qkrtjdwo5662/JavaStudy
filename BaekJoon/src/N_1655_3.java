import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class N_1655_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 1        // 1
        // 1  5     // 1
        // 1  5  2  // 2
        // 1  5  2  10 // 2
        // 1  5  2  10 - 99// 2

        // 1        5
        // 1  2     5  10
        PriorityQueue<Integer> pq_min = new PriorityQueue<>();
        PriorityQueue<Integer> pq_max = new PriorityQueue<>(Collections.reverseOrder());


        for (int i = 0; i <  n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(pq_min.size() == pq_max.size()){
                pq_max.add(num);
            }else pq_min.add(num);

            if(!pq_max.isEmpty() && !pq_min.isEmpty()){
                if(pq_max.peek() > pq_min.peek()){
                    int poll_max = pq_max.poll();
                    pq_min.add(poll_max);

                    int poll_min = pq_min.poll();
                    pq_max.add(poll_min);
                }
            }


            sb.append(pq_max.peek()).append("\n");

        }
        System.out.println(sb);
    }
}
