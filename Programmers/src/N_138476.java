import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class N_138476 {

    public static void main(String[] args) {
        int answer = solution(6, new int[]{1,3,2,5,4,5,2,3});
        System.out.println(answer);
    }

    static int solution(int k, int[] tangerine){
        int answer =0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            int size = tangerine[i];

            if(!map.containsKey(size)){
                map.put(size, 1);
            }else map.put(size, map.get(size) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(Integer key:map.keySet()){
            pq.add(map.get(key));
        }

        while(!pq.isEmpty()){
            int poll = pq.poll();
            answer ++;
            k = k - poll;
            if(k <= 0) {
                break;
            }


        }
        return answer;
    }
}
