import java.util.ArrayList;
import java.util.Arrays;

public class MockExam_3 {
    public static int[] answers = {1,3,2,4,2};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(answers)));
    }
    public static int[] solution(int[] answers){
        int[] count = new int[4];
        int[] result = new int[4];
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};

        for (int i = 0; i < answers.length; i++) {
            int num = answers[i%answers.length];

            if(num == one[i%one.length]) {
                count[1] ++;
                result[1] ++;
            }
            if(num == two[i%two.length]) {
                count[2] ++;
                result[2] ++;
            }
            if(num == three[i%three.length]) {
                count[3] ++;
                result[3] ++;
            }
        }

        Arrays.sort(result);
        int max = result[3];

        for (int i = 1; i < count.length; i++) {
            if(max == count[i]) arrayList.add(i);
        }

        int[] answer = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }
        
        return answer;
    }
}
