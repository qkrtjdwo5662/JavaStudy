import java.util.HashMap;

public class Fail_2 {
    public static String[] participant = {"mislav", "stanko", "mislav", "ana"};
    public static String[] completion = {"stanko", "ana", "mislav"};
    public static void main(String[] args) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        for (int i = 0; i < completion.length; i++) {
            if(hashMap.containsKey(completion[i])){
                hashMap.put(completion[i], hashMap.get(completion[i])+1);
            }else hashMap.put(completion[i], 1);
        }
        for (int i = 0; i < participant.length; i++) {
            if(hashMap2.containsKey(participant[i])){
                hashMap2.put(participant[i], hashMap2.get(participant[i])+1);
            }else hashMap2.put(participant[i], 1);
        }

        System.out.println(hashMap2);
        System.out.println(hashMap);
        System.out.println(hashMap2);
        System.out.println(hashMap);
    }
}
