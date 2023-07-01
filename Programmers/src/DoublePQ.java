import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePQ {
    public static String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
//    public static String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(operations)));
    }

    public static int[] solution(String[] operations){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> temp = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < operations.length; i++) {
            String[] operation = operations[i].split(" ");
            for (int j = 0; j < operation.length; j++) {
                if(operation[0].equals("I")){ // 명령어 I
                    pq.add(Integer.parseInt(operation[1])); // 1번째 원소 넣어주고
                }else{ // 명령어 D
                    if(operation[1].equals("-1")){ // 최솟값 삭제
                        pq.poll(); // 삭제
                    }else{ // 최댓값 삭제
                        temp.addAll(pq); //temp에 넣어주고
                        pq.remove(temp.poll()); // 최댓값 찾아서 삭제
                    }
                }
            }
        }
        if(pq.isEmpty()){
           return new int[]{0,0};
        }else{
            temp.clear();
            temp.addAll(pq);
           return new int[]{temp.poll(),pq.poll()};
        }

    }
}
