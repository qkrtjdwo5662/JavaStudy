import java.util.Arrays;
import java.util.HashMap;

public class HotelRoom_2 {
    public static long k = 10;
    public static long[] room_number = {1,3,4,1,3,1};

    public static HashMap<Long, Long> parent;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(k, room_number)));
    }

    public static long[] solution(long k, long[] room_number){
        long[] answer = new long[room_number.length];
        parent = new HashMap<>();
        for (int i = 0; i < room_number.length; i++) {
            answer[i] = find(room_number[i]);
        }
        return answer;
    }

    public static long find(long a){
        if(!parent.containsKey(a)){
            parent.put(a, a+1);
            return a;
        }else{
            parent.put(a, parent.get(a));
            return find(parent.get(a));
        }

    }
}
