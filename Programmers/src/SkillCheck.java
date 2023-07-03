import java.util.ArrayDeque;
import java.util.HashMap;

public class SkillCheck {
    public static String s ="}]()[{";
    public static void main(String[] args) {
        System.out.println(solution(s));
    }
    public static int solution(String s){
        HashMap<java.lang.Character, java.lang.Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('[', ']');
        hashMap.put('{', '}');

        int answer = 0;


        for (int i = 0; i < s.length(); i++) {
            ArrayDeque<java.lang.Character> arrayDeque = new ArrayDeque<>();
            boolean flag = false;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt((i+j)%(s.length()));

                if(hashMap.containsKey(c)){ // 여는 괄호
                    arrayDeque.addLast(c);
                }else{ // 닫는 괄호
                    if(!arrayDeque.isEmpty()){ // 안비었으면
                        if(hashMap.get(arrayDeque.pollLast()) != c){ // 짝맞는지 체크
                            flag = true;
                            break;
                        }
                    }else{ // 비었으면
                        flag = true;
                        break;
                    }
                }
            }
            if(flag) continue;

            if(arrayDeque.isEmpty()){
                answer++;
            }
        }


        return answer;
    }
}
