import java.util.Arrays;

public class HotelRoom_fail {
    public static long k = 10;
    public static long[] room_number = {1,3,4,1,3,1};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(k, room_number)));
    }

    public static long[] solution(long k, long[] room_number){
        long[] answer = new long[room_number.length];
        boolean[] check  = new boolean[(int) k];

        for (int i = 0; i < room_number.length; i++) {
            if(!check[(int)room_number[i]]){
                answer[i] = room_number[i];
                check[(int)room_number[i]] = true;
            }else{
                System.out.println();
                for (int j = (int)room_number[i]+1; j < check.length; j++) {
                    if(!check[j]){
                        answer[i] = j;
                        check[j] = true;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}
