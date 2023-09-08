import java.util.Arrays;
import java.util.HashMap;

public class HotelRoom_fail2 {
    public static long k = 10;
    public static long[] room_number = {1,3,4,1,3,1};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(k, room_number)));

    }

    public static long[] solution(long k, long[] room_number){
        long[] answer = new long[room_number.length];

        HashMap<Long, Long> hashMap = new HashMap<>();
        for (int i = 0; i < room_number.length; i++) {
            if(!hashMap.containsKey(room_number[i])){
                hashMap.put(room_number[i], room_number[i]);
                answer[i] = room_number[i];
            }else{
                for (long j = room_number[i]+1; j < k; j++) {
                    if(!hashMap.containsKey(j)){
                        hashMap.put(j, j);
                        answer[i] = j;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}
