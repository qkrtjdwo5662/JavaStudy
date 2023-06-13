import java.util.ArrayDeque;
import java.util.Arrays;

public class FunctionDevelopment {
//    public static int[] progresses = {93, 30, 55};
//    public static int[] speeds = {1, 30, 5};

    public static int[] progresses = {95, 90, 99, 99, 80, 99};
    public static int[] speeds = {1, 1, 1, 1, 1, 1};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int[] days = new int[progresses.length];

        for (int i = 0; i < days.length; i++) {
            int day = 0;
            progresses[i] = 100 - progresses[i];
            while(progresses[i]>0){
                progresses[i] = progresses[i] - speeds[i];
                day++;
            }
            days[i] = day;
        }

        int temp = 0;
        for (int i = 0; i < days.length; i++) {
            if(temp<days[i]){
                temp = days[i];
                arrayDeque.addLast(1);
            }else{
                arrayDeque.addLast(arrayDeque.pollLast()+1);

            }
        }

        int[] answer = new int[arrayDeque.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrayDeque.pollFirst();
        }

        return answer;
    }
}
