import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class OpenChat {
    public static String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(record)));
    }

    public static String[] solution(String[] record){
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<String, String> userInfo = new HashMap<>();

        for (int i = 0; i < record.length; i++) { // 처음에는 userInfo hash에 정보만 넣어준다.
            String[] act = record[i].split(" "); // 공백으로 record[i] 짤라주고
            if(act[0].equals("Enter")){ // enter 상황
                userInfo.put(act[1], act[2]);
            } else if(act[0].equals("Change")){ // change 상황
                userInfo.put(act[1], act[2]);
            }
        }

        for (int i = 0; i < record.length; i++) { // 출력을 위한 부분 (enter, leave)
            String[] act = record[i].split(" "); // 공백으로 record[i] 짤라주고
            if(act[0].equals("Enter")){
                arrayList.add(userInfo.get(act[1])+"님이 들어왔습니다.");
            } else if (act[0].equals("Leave")) {
                arrayList.add(userInfo.get(act[1])+"님이 나갔습니다.");
            }
        }


        String[] answer = new String[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }
}
