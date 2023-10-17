import java.util.HashMap;
import java.util.Stack;

public class RotateBracket_3 {
    public static String s = "[](){}";

    public static void main(String[] args) {
        System.out.println(solution(s));
    }

    public static int solution(String s){
        int answer = 0;
        int index = 0;

        // hash 사용
        // 여는괄호: key  닫는괄호: value

        // 회전 -> s+s
        // "[](){}[](){}"

        HashMap<java.lang.Character, java.lang.Character> hash = new HashMap<>();
        hash.put('(', ')');
        hash.put('[', ']');
        hash.put('{', '}');

        int n = s.length();
        s = s+s;

        loop:
        while(index < n){
            Stack<java.lang.Character> stack = new Stack<>();
            for (int i = index; i < n+index ; i++) {

                if(hash.containsKey(s.charAt(i))){
                    stack.push(s.charAt(i));
                }else{
                    if(stack.isEmpty()){
                       index ++;
                       continue loop;
                    }else{
                        if(hash.get(stack.pop()) != s.charAt(i)){
                            index ++;
                            continue loop;
                        }

                    }
                }

            }
            if(stack.isEmpty()){
                answer++;
            }
            index ++;
        }



        return answer;
    }
}
