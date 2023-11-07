import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LargestNumber_2 {
    public static int[] numbers = {6, 10, 2};

    public static void main(String[] args) {
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers){
        StringBuilder answer = new StringBuilder();

        // 6, 10  610 > 106
        // 10, 2  102 < 210

        ArrayList<String> list = new ArrayList<>();

        for (int number : numbers) {
            list.add(String.valueOf(number));
        }

        Collections.sort(list, (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1 + o2), Integer.parseInt(o2 + o1));
        });

        for (int i = list.size()-1; i >=0; i--) {
            answer.append(list.get(i));
        }

        if(answer.charAt(0) == '0') return "0";
        return String.valueOf(answer);
    }
}
