import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;

public class DefenseGame {
    static int n = 2;
    static int k = 4;
    static int[] enemy = {3,3,3,3};

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
            if(n>=0){
                //빼고나서 0이상이면 라운드 통과 처리
                answer = answer+1;
            }else{
                if(k>0){
                    k--; //무조건 쓰고
                    answer++; //라운드 통과
                }else{
                    break;
                }

            }
        }
        return answer;
    }
}
