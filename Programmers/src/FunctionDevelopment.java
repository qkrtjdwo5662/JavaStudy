import java.util.ArrayDeque;

public class FunctionDevelopment {
//    public static int[] progresses = {93, 30, 55};
//    public static int[] speeds = {1, 30, 5};

    public static int[] progresses = {95, 90, 99, 99, 80, 99};
    public static int[] speeds = {1, 1, 1, 1, 1, 1};

    public static void main(String[] args) {
        solution(progresses, speeds);
    }

    public static int[] solution(int[] progresses, int[] speeds){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        int distribution = 0;
        int max = 0;
        for (int i = 0; i < progresses.length; i++) {
            progresses[i] = 100 - progresses[i];
            int divide_count = 0;
            while(progresses[i]>0){
                progresses[i] = progresses[i] - speeds[i];
                divide_count++;
            }
            if(max < divide_count){
                max = divide_count;
                arrayDeque.addLast(1);
            }else{
                max = max - divide_count;
                arrayDeque.addLast(arrayDeque.peekLast()+1);
                arrayDeque.pollFirst();
            }
        }
        int[] answer = new int[arrayDeque.size()];
        System.out.println(arrayDeque);
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrayDeque.pollFirst();
        }

        return answer;
    }
}
