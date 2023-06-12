import java.util.ArrayDeque;
import java.util.HashMap;

public class RightBracket4 {
//    public static String s = "[](){}";
//    public static String s = "}]()[{";
    public static String s = "[)(]";

    public static void main(String[] args) {
        System.out.println(solution(s));
    }
    public static int solution(String s){
        int answer = 0;
        HashMap<java.lang.Character, java.lang.Character> hashMap= new HashMap<>();
        hashMap.put('(',')');
        hashMap.put('[',']');
        hashMap.put('{','}');

        for (int i = 0; i <s.length() ; i++) {
            ArrayDeque<java.lang.Character> arrayDeque = new ArrayDeque<>();
            boolean flag = false;
            for (int j = 0; j <s.length(); j++) {
                char now = s.charAt((i+j)%s.length());
                if(hashMap.containsKey(now)){
                    arrayDeque.addLast(now);
                }else {
                    if(arrayDeque.isEmpty()){
                        flag = true;
                        break;
                    }else{
                        if(now != hashMap.get(arrayDeque.pollLast())){
                            flag = true;
                            break;
                        }
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
