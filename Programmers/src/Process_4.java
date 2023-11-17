import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;

public class Process_4 {
    public static int[] priorities = {2, 1, 3, 2};
    public static int location = 2;

    public static void main(String[] args) {
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location){
        int answer = 0;

        ArrayDeque<int[]> deque = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            deque.addLast(new int[]{priorities[i], i});
            pq.add(priorities[i]);
        }


        while(!pq.isEmpty()){
            int poll = pq.poll();

            int index = 0;
            while(!deque.isEmpty()){
                int[] now = deque.pollFirst();

                if(now[0] != poll){ // 다르면
                    deque.addLast(now);
                }else{ // 같다면
                    answer ++;
                    index = now[1];
                    break;
                }
            }

            if(index == location) break;

        }
        return answer;
    }
}
