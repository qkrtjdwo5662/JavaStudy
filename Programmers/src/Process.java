import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;

public class Process {
    public static int[] priorities = {1, 1, 9, 1, 1, 1};
    public static int location = 0;

    public static void main(String[] args) {
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location){
        int answer = 0;

        ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();
        PriorityQueue<Integer> pq =new PriorityQueue<>(Collections.reverseOrder());

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]); // 3 , 2 , 2, 1
            arrayDeque.addLast(new int[]{i,priorities[i]}); //
        }

        int count = 1;
        while(!pq.isEmpty()){
            int now = pq.poll();

            while(true){
                int[] arr = arrayDeque.pollFirst();
                if(arr[1] == now){
                    if(arr[0]== location){
                        answer = count;
                        return answer;
                    }else break;
                }else arrayDeque.addLast(arr);
            }
            count++;
        }

        System.out.println(ad);


        return answer;
    }
}
