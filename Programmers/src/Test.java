import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        PriorityQueue <int[]> pq = new PriorityQueue<>((o1,o2) -> {
            if(o1[0] == o2[0])
                return Integer.compare(o1[1], o2[1]);
            else return Integer.compare(o1[0], o2[0]);
        });

        pq.add(new int[]{0,1});
        pq.add(new int[]{0,2});
        pq.add(new int[]{0,3});
        pq.add(new int[]{1,1});
        pq.add(new int[]{1,2});
        pq.add(new int[]{1,3});

        while(!pq.isEmpty()){
            System.out.println(Arrays.toString(pq.poll()));
        }
    }
}
