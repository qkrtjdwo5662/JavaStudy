import java.util.HashMap;

public class Fail {
    public static String[] participant = {"mislav", "stanko", "mislav", "ana"};
    public static String[] completion = {"stanko", "ana", "mislav"};
    public static void main(String[] args) {
        System.out.println(solution(participant, completion));
    }
    public static String solution(String[] participant, String[] completion){
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < completion.length; i++) {
            if(hashMap.containsKey(completion[i])){
                hashMap.put(completion[i], hashMap.get(completion[i])+1);
            }else hashMap.put(completion[i], 1);
        }

        for (int i = 0; i < participant.length; i++) {
            if(hashMap.containsKey(participant[i])){
                hashMap.put(participant[i], hashMap.get(participant[i])-1);
                if(hashMap.get(participant[i])<0) return participant[i];
                else continue;
            }else return participant[i];
        }

        return answer;
    }
}
