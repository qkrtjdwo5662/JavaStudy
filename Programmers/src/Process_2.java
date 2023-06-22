import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;

public class Process_2 {
    public static int[] priorities = {1,1,9,1,1,1};
    public static int location = 0;
    public static void main(String[] args) {
        System.out.println(solution(priorities, location));
    }
    public static int solution(int[] priorities, int location){
        // 우선순위가 높을수록 먼저 꺼내야 함
        // 꺼내고 우선순위가 더 높은 프로세스 있으면 다시 큐에 넣음 (큐 회전 방식)
        // 아니면 그냥 실행

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i <priorities.length ; i++) {
            arrayDeque.addLast(i); // 0, 1, 2, 3 -> location과 비교, priorities의 index
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]); // 3, 2, 2, 1 -> 우선순위대로 입력 받고 우선순위 대로 꺼냄
        }

        int count = 1; // 몇 번째 실행?
        while(true){
            int maxRanking = pq.poll(); // 3

            while(maxRanking != priorities[arrayDeque.peekFirst()]){
                arrayDeque.addLast(arrayDeque.pollFirst());
            } // 같을 때 까지 회전

            // 같으면 뽑아주고
            int index = arrayDeque.pollFirst();

            // 뽑아준게 location하고 같으면 return
            if(location == index){
                return count;
            }


            count ++;
        }

    }
}
