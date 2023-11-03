import java.util.Arrays;
import java.util.HashMap;

public class week_4_4 {
    public static long[] room_number = {1,3,4,1,3,1};
    public static long k = 10;
    public static HashMap<Long, Long> map;
    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(k, room_number)));
    }

    public static long[] solution(long k, long[] room_number){
        // 1, 3, 4, 1, 3, 1
        map = new HashMap<>();

        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = find(room_number[i]);
        }

        return answer;
    }

    public static long find(long a){
        if(!map.containsKey(a)){
            map.put(a, a+1);

            return a;
        }
        //else
        map.put(a, find(map.get(a)));
        return map.get(a);
    }


}
