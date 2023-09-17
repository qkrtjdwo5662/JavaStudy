import java.util.ArrayList;
import java.util.Arrays;

public class FunctionDevelopment_3 {
    public static int[] progresses = {95, 90, 99, 99, 80, 99};
    public static int[] speeds = {1, 1, 1, 1, 1, 1};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }
    public static int[] solution(int[] progresses, int[] speeds){
        int n = progresses.length; // speeds length;
        int max = Integer.MIN_VALUE;
        int count = 1;

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int remain = 100 - progresses[i];
            int day = 0;
            while(remain > 0){
                remain = remain - speeds[i];
                day++;
            }
            if(max < day) {
                if(i!=0){
                    arrayList.add(count); // 넣고
                }
                max = day;
                count = 1; // 초기화
            }else{
                count++;

            }
        }
        arrayList.add(count);


        int[] answer = new int[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }
        return answer;
    }
}
