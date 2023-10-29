import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class OpenChat_2 {
    public static String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(record)));
    }

    public static String[] solution(String[] record){
        ArrayList<String> arrList = new ArrayList<>();

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < record.length; i++) {
            String[] arr = record[i].split(" ");

            String opr = arr[0];


            if(opr.equals("Enter")){
                map.put(arr[1], arr[2]);
            }else if(opr.equals("Change")){
                map.put(arr[1], arr[2]);
            }
        }

        for (int i = 0; i < record.length; i++) {
            String[] arr = record[i].split(" ");

            String opr = arr[0];
            String id = arr[1];

            if(opr.equals("Enter")){
                arrList.add(map.get(id) + "님이 들어왔습니다.");
            }else if(opr.equals("Leave")){
                arrList.add(map.get(id) + "님이 나갔습니다.");
            }
        }

        String[] answer = new String[arrList.size()];

        for (int i = 0; i < arrList.size(); i++) {
            answer[i] = arrList.get(i);
        }

        return answer;
    }
}
