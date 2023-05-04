import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class LargestNumber {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        System.out.println(solution(numbers));
    }
//        int[] numbers = {3, 30, 34, 5, 9};

    static public String solution(int[] numbers){
        String answer = "";

        //맨 앞자리 수만 남겨놓기
        int temp[] = numbers;
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            while(temp[i]>=10){
                temp[i] = temp[i]/10;
            }
        }
        

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            answer = answer + numbers[i];
        }
        return answer;
    }

}
