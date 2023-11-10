import java.util.ArrayList;
import java.util.Collections;

public class Week_5_1 {
    public static int[] numbers = {6, 10, 2};
    public static void main(String[] args) {
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers){
        // 6, 10 -> 610 > 106
        // 10, 2 -> 102 < 210
        StringBuilder answer = new StringBuilder();

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
        }

        Collections.sort(list, (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1 + o2), Integer.parseInt(o2 + o1));
                                                        //610                        106
        });

        System.out.println(list);
        for (int i = list.size()-1; i >= 0 ; i--) {
            answer.append(list.get(i));
        }
        // 000000000 => 0
        if(answer.charAt(0) == '0') return "0";
        return answer.toString();
    }
}
