import java.util.Collections;
import java.util.PriorityQueue;

public class DefenseGame2 {
    static int n = 2;
    static int k = 4;
    static int[] enemy = {3, 3, 3, 3};

    int index;
    public static void main(String[] args) {
        System.out.println(solution(n,k,enemy));
    }
    static int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < enemy.length; i++) {
            n = n - enemy[i]; //일단 빼보기
            queue.add(enemy[i]);// 큐에 넣기(오름차순 우선순위 큐)
            if(n<0){
                if(k>0){    //카드 남았으면
                    k--; //무조건 쓰고
                    n = n+queue.poll(); // 다시 더해주기
                    answer++; // answer값 올리기
                }else{ // n과 k 모두 0 미만이면 게임종료
                    answer = i;
                    break;
                }
            }else{
                continue;
            }
        }

        return answer;
    }
}
