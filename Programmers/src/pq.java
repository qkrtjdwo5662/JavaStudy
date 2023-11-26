import java.util.PriorityQueue;

public class pq {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();


        pq.add(10);
        pq.add(4);
        pq.add(9);
        pq.add(5);
        pq.add(1);
        pq.add(10);
        pq.add(3);
        pq.add(4);
        pq.add(7);

        System.out.println(pq);


        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

    }
}

