import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;

public class Process_6 {
    public static int[] priorities = {2, 1, 3, 2};
    public static int location = 2;

    public static void main(String[] args) {
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location){
        int answer = 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            queue.addLast(new int[]{i, priorities[i]});
        }

        while(!pq.isEmpty()){
            int poll = pq.poll();

            while(queue.peekFirst()[1] != poll){
                int[] now = queue.pollFirst();

                queue.addLast(now);
            }

            int[] now = queue.pollFirst();
            if(location == now[0]) break;

            answer++;
        }

        return answer;
    }
}
