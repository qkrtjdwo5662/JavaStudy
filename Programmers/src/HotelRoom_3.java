
import java.util.Arrays;
import java.util.HashMap;

public class HotelRoom_3 {
    public static long k = 10;
    public static long[] room_number = {1,3,4,1,3,1};

    public static HashMap<Long, Long> map;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(k, room_number)));
    }

    public static long[] solution(long k, long[] room_number){
        int n = room_number.length;
        long[] answer = new long[n];

        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long num = room_number[i];

            answer[i] = find(num);
        }

        return answer;
    }

    public static long find(long a){
        if(!map.containsKey(a)){
            map.put(a, a+1);
            return a;
        }

        long num = map.get(a);
        map.put(a, num);
        return find(num);
    }
}
