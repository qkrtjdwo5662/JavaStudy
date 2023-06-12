import java.util.HashMap;
import java.util.Stack;

public class RotateBracket_2 {
    public static String s = "[](){}";

    public static void main(String[] args) {
        System.out.println(solution(s));
    }
    public static int solution(String s){
        int answer = 0;


        HashMap<java.lang.Character, java.lang.Character> hashMap = new HashMap<>();
        hashMap.put('(',')');
        hashMap.put('[',']');
        hashMap.put('{','}');

        for (int i = 0; i < s.length(); i++) {
            Stack<java.lang.Character> stack = new Stack<>();
            boolean flag = false; // 최종 스택 검토가 필요한지
            for (int j = 0; j < s.length(); j++) {
                // 회전
                // 0,1,2,3,4,5
                // 1,2,3,4,5,0
                // 2,3,4,5,0,1
                // ...
                char now = s.charAt((i+j) % s.length());

                if(hashMap.containsKey(now)){ // 여는 괄호리면
                    stack.push(now);
                } else { // 닫는 괄호라면
                    if(stack.isEmpty()){ // 스택 비었는지 확인
                        flag = true;
                        break;
                    } else if (now != hashMap.get(stack.pop())) { // 짝이 맞는지 확인
                        flag = true;
                        break;
                    }
                }
            }

            if(flag) continue;

            if(stack.isEmpty()){
                answer++;
            }
        }

        return answer;
    }
}
