import java.util.Collections;
import java.util.PriorityQueue;

public class MinRectangle {
    public static int[][] sizes ={{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
    public static void main(String[] args) {
        System.out.println(solution(sizes));
    }
    public static int solution(int[][] sizes){
        int answer = 0;
        // 1. 가장 큰 값 먼저 구함 그리고 열 위치 파악
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < sizes.length; i++) {
            for (int j = 0; j < sizes[0].length; j++) {
                pq.add(sizes[i][j]);
            }
        }
        int max = pq.poll();
        pq.clear();
        // 큰 값과의 차가 적은 것을 0열 , 차가 큰 것을 1열에 모아 놓는다.
        for (int i = 0; i < sizes.length; i++) {
            for (int j = 0; j < sizes[0].length; j++) {
                if(max-sizes[i][0] > max-sizes[i][1]){
                    int temp = 0;
                    temp = sizes[i][0];
                    sizes[i][0] = sizes[i][1];
                    sizes[i][1] = temp;
                }
                pq.add(sizes[i][1]);
            }
        }
        int max_second = pq.poll();

        answer = max * max_second;
        return answer;
    }
}
