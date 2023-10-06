import java.util.ArrayList;
import java.util.Arrays;

public class Week_2_3 {
    public static int[] progresses = {95, 90, 99, 99, 80, 99};
    public static int[] speeds = {1, 1, 1, 1, 1, 1};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds){
        ArrayList<Integer> arrayList = new ArrayList<>();

        int max = 0;
        int count = 1;
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];

            int day = 0;

            while(remain > 0){
                remain = remain - speeds[i];
                day ++;

            }

            if(day > max) {
                if(i==0){
                    max = day;
                    continue;
                }
                max = day;
                arrayList.add(count);
                count = 1;
                continue;
            }

            count ++;

        }
        arrayList.add(count);

        int[] answer = new int[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }
        return answer;
    }
}
