import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;

public class Process_5 {
    public static int[] priorities = {2, 1, 3, 2};
    public static int location = 2;

    public static void main(String[] args) {
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location){
        int answer = 0;


        // 우선순위 큐 -> 우선순위 높은 순으로 실행
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < priorities.length ; i++) {
            pq.add(priorities[i]);
            deque.addLast(new int[]{priorities[i], i});
        }

        while(!pq.isEmpty()){
            int poll = pq.poll();
            int index = 0;
            while(!deque.isEmpty()){
                int[] now = deque.pollFirst();

                if(now[0] != poll){
                    deque.addLast(now);
                }else{
                    index = now[1];
                    answer++;
                    break;
                }
            }

            if(index == location) break;
        }

        return answer;
    }
}
