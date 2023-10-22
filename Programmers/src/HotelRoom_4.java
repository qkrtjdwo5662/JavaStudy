import java.util.Arrays;
import java.util.HashMap;

public class HotelRoom_4 {
    public static long k = 10;
    public static long[] room_number = {1,3,4,1,3,1};

    public static HashMap<Long, Long> map;
    public static void main(String[] args) {
        System.out.println(solution(k, room_number));
    }

    public static long[] solution(long k, long[] room_number){
        long[] answer = new long[room_number.length];
        map = new HashMap<>();
        for (int i = 0; i < room_number.length; i++) {
            answer[i] =find(room_number[i]);
        }

        return answer;
    }

    public static long find(long a){
        if(!map.containsKey(a)){
            map.put(a, a+1); // 1번 차면 2번 방문 열어놓음
            return a;
        }
        map.put(a, map.get(a));
        return find(map.get(a));
    }
}
