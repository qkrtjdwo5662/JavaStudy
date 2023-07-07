import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= 5; i++) {
            pq.add(i);
        }

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 1; i <= 5 ; i++) {
            pq2.add(i);
        }

        while(!pq2.isEmpty()){
            System.out.println(pq2.poll());
        }
    }
}
