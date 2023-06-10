import java.util.ArrayDeque;

public class NotEqual_2 {
    static int[] arr = {1,1,3,3,0,1,1};
    public static void main(String[] args) {
        System.out.println(solution(arr));
    }
    public static int[] solution(int[] arr){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        arrayDeque.addLast(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]!=arrayDeque.peekLast()){
                arrayDeque.addLast(arr[i]);
            }
        }
        int[] answer = new int[arrayDeque.size()];

        int index =0;
        while(!arrayDeque.isEmpty()){
            answer[index] = arrayDeque.pollFirst();
            index++;
        }

        return answer;
    }
}
