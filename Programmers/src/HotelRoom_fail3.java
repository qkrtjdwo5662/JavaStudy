import java.util.ArrayList;
import java.util.Arrays;

public class HotelRoom_fail3 {
    public static long k = 10;
    public static long[] room_number = {1,3,4,1,3,1};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(k, room_number)));
    }

    public static long[] solution(long k, long[] room_number){
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i = 0; i < room_number.length; i++) {
            if(!arrayList.contains(room_number[i])){
                arrayList.add(room_number[i]);
            }else{
                long now = room_number[i];

                while(arrayList.contains(now)){
                    now = now+1;
                }

                if(now <= k) arrayList.add(now);
            }
        }
        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = arrayList.get(i);
        }
        return answer;
    }
}
