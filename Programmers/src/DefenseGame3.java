import java.util.Collections;
import java.util.PriorityQueue;

public class DefenseGame3 {
    public static int n = 7; // 내 병사
    public static int k = 3; // 무적권
    public static int[] enemy = {4, 2, 4, 5, 3, 3, 1};
    public static void main(String[] args) {
        System.out.println(solution(n, k, enemy));
    }
    public static int solution(int n, int k, int[] enemy){
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            pq.add(enemy[i]);
            if(n-enemy[i]>=0){
                n = n-enemy[i];
            }else{
                if(!pq.isEmpty()){
                    n = n + pq.poll();
                    k--;
                    n = n-enemy[i];
                }else{
                    break;
                }
            }
//            System.out.println("n : "+ n);
            System.out.println("k : "+ k);
            if(k<0) break;
            answer++;
        }


        return answer;
    }
}
