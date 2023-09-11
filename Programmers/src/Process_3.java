import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;

public class Process_3 {
    public static int[] priorities = {1,1,9,1,1,1};
    public static int location = 0;
    public static void main(String[] args) {

        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location){
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            deque.addLast(new int[]{priorities[i], i});
        }

        while(!pq.isEmpty()){
            int poll = pq.poll();
            int[] now = {-1, -1};
            while(!deque.isEmpty()){
                now = deque.pollFirst();

                if(poll == now[0]){
                    answer++;
                    break;
                }else{
                    deque.addLast(now);
                }
            }

            if(now[1] == location){
                break;
            }
        }


        return answer;
    }
}
