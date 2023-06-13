import java.util.Arrays;
import java.util.Stack;

public class Main {
//    public static int[] progresses = {93, 30, 55};
//    public static int[] speeds = {1, 30, 5};

    public static int[] progresses = {95, 90, 99, 99, 80, 99};
    public static int[] speeds = {1, 1, 1, 1, 1, 1};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds){
        Stack<Integer> stack = new Stack<>();
        int[] days = new int[progresses.length];

        for (int i = 0; i < days.length; i++) {
            progresses[i] = 100 - progresses[i];

            days[i] = progresses[i] / speeds[i];
            if(progresses[i] % speeds[i]>0){
                days[i] ++;
            }
        }

        int temp = 0;
        for (int i = 0; i < days.length; i++) {
            if(temp<days[i]){
                temp = days[i];
                stack.push(1);
            }else{
                stack.push(stack.pop()+1);
            }
        }

        int[] answer = new int[stack.size()];

        for (int i = answer.length-1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}
