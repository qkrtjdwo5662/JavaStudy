import java.util.ArrayList;
import java.util.Arrays;

public class FunctionDevelopment_2 {
    public static int[] progresses = {95, 90, 99, 99, 80, 99};
    public static int[] speeds = {1, 1, 1, 1, 1, 1};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds){
        ArrayList<Integer> arrayList = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        int count = 0;

        int n = progresses.length; // speeds.length
        for (int i = 0; i < n; i++) {
            int remain = 100 - progresses[i];
            int speed = speeds[i];
            int day = 0;

            while(remain > 0){
                remain = remain - speed;
                day ++;
            }
            if(day > max) {
                if(i!=0){
                    arrayList.add(count); // 갱신되면 넣기
                }
                max = day; // 갱신
                count = 1; // count 1 초기화
            }else{
                count++;
            }

            if(i== n-1) arrayList.add(count);

        }

        int[] answer = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }
        return answer;
    }
}
