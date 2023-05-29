import java.util.HashMap;

public class PhoneNumberList_Hash {
    public static String[] phone_number = {"119", "97674223", "1195524421"};

    public static void main(String[] args) {
        System.out.println(solution(phone_number));
    }
    public static boolean solution(String[] phone_number){
        boolean answer = true;
        HashMap<String, Integer> hashMap= new HashMap<>();
        for(int i=0; i< phone_number.length; i++){
            hashMap.put(phone_number[i],i);
        }
        for(int i=0; i<hashMap.size(); i++){
            if(hashMap.containsKey(phone_number[i])){
                answer = false;
                System.out.println(phone_number[i]);
            }
        }


        return answer;
    }
}
