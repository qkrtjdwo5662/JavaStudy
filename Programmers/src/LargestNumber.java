import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class LargestNumber {
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }
//

    static public String solution(int[] numbers){
        String answer = "";

        String[] temp = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            temp[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(temp, new Comparator<>() {
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        for (int i = 0; i < temp.length; i++) {
            answer = answer + temp[i];
        }

        if(answer.charAt(0)=='0') return "0";

        return answer;
    }

}
