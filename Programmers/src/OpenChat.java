public class OpenChat {
    public static String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

    public static void main(String[] args) {
//        System.out.println(solution(record));
        solution(record);
    }

    public static String[] solution(String[] record){
        String[] answer = new String[record.length];

        for (int i = 0; i < record.length; i++) {
            String[] sentence = record[i].split(" ");
            System.out.println(sentence[0]);

            if(sentence[0].equals("Enter")){
                answer[i] = sentence[2] + "님이 들어왔습니다.";
            } else if (sentence[0].equals("Leave")) {
                answer[i] = sentence[2] + "님이 나갔습니디.";
            }else answer[i]  = sentence[2] + "님이 닉네임 바꿈.";
        }

        return answer;
    }
}
