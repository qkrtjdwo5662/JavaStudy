import java.util.Collections;
import java.util.PriorityQueue;

public class SteppingStone_2 {
    public static int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
    public static int k = 3;
    public static void main(String[] args) {
        System.out.println(solution(stones, k));
    }
    public static int solution(int[] stones, int k){
        int answer = 0;
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> min_2 = new PriorityQueue<>();
        for (int i = 0; i < stones.length-k+1; i++) {
            for (int j = 0; j < k; j++) {
                min.add(stones[i+j]);
            }
            for (int j = 0; j < k-1; j++) {
                min.poll();
            }
            min_2.add(min.poll());
            System.out.println(min_2);
        }

        answer = min_2.poll(); // 구간 최대값의 최소값
        return answer;
    }
}
