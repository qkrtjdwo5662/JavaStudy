import java.util.Collections;
import java.util.PriorityQueue;

public class PrQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pr = new PriorityQueue<>();

        pr.add(10);
        pr.add(9);
        pr.add(4);
        pr.add(5);

        PriorityQueue<Integer> pr2 = new PriorityQueue<>(Collections.reverseOrder());
        pr2.add(10);
        pr2.add(9);
        pr2.add(4);
        pr2.add(5);

        System.out.println(pr);
        System.out.println(pr2);

        while(!pr.isEmpty()){
            System.out.print(pr.poll()+" ");
        }
        System.out.println("-----------");

        while(!pr2.isEmpty()){
            System.out.print(pr2.poll()+" ");
        }

        // 우선 순위 큐는 데이터를 출력하는 것과 poll 했을때의 값이 다르다.
        // 확실한 우선 순위 큐를 구현하기 위해서는 모든 데이터를 poll 해야 함.
    }
}
