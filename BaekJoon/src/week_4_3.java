import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class week_4_3 {
    public static String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(record)));
    }

    public static String[] solution(String[] record){
        // map 사용 -> key, value

        // key : user ID
        // value : user nick


        // 이벤트 상황
        // 들어올때, 나갈때 -> 닉네임이 변할 수 있다.

        // record 이벤트에 맞게 출력값을 넣어줘야한다.
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String[] arr = record[i].split(" ");
            // arr[0] : event
            // arr[1] : userid
            // arr[2] : user nick

            String opr = arr[0];

            if(opr.equals("Enter") || opr.equals("Change")){
                map.put(arr[1], arr[2]);
            }
        }


        for (int i = 0; i < record.length; i++) {
            String[] arr = record[i].split(" ");
            // arr[0] : event
            // arr[1] : userid
            // arr[2] : user nick

            String opr = arr[0];

            if(opr.equals("Enter")){
                list.add(map.get(arr[1]) + "님이 들어왔습니다.");
            }else if(opr.equals("Leave")){
                list.add(map.get(arr[1]) + "님이 나갔습니다.");
            }
        }



        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
