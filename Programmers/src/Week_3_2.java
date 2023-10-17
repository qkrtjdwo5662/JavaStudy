import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

public class Week_3_2 {
    public static String s = "[](){}";

    public static void main(String[] args) {
        System.out.println(solution(s));
    }

    public static int solution(String s){
        int answer = 0;


        // 여는 괄호 : push
        // 닫는 괄호 : pop

        // hash -> 미리 짝을 넣어준다.

        HashMap<java.lang.Character, java.lang.Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('[', ']');
        hashMap.put('{', '}');

        // hash key : 여는괄호
        // hash value : 닫는괄호

        // s-> s+s
        // "[](){}[](){}"

        int n = s.length();
        s = s+s;

        int index = 0;

        loop:
        while(index < n){
            Stack<java.lang.Character> stack = new Stack<>();
            for (int i = index; i < n+index; i++) {

                if(hashMap.containsKey(s.charAt(i))){ // 여는괄호
                    stack.push(s.charAt(i));

                }else{ // 닫는괄호
                    if(stack.isEmpty()){
                        // 올바른 괄호 X
                        index++;
                        continue loop;
                    }else{
                        if(hashMap.get(stack.pop()) != s.charAt(i)){
                            index++;
                            continue loop;
                        }
                    }
                }

            }
            if(stack.isEmpty()){
                //올바른 괄호
                answer++;
            }

            index++;
        }


        return answer;
    }
}
