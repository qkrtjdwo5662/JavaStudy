import java.util.HashMap;
import java.util.Stack;

public class ChangeBracket {
    public static StringBuilder answer;
    public static String p = "()))((()";
    public static HashMap<java.lang.Character, java.lang.Character> hashMap;
    public static void main(String[] args) {
        System.out.println(solution(p));
    }

    public static String solution(String p) {
        answer = new StringBuilder();
        hashMap = new HashMap<>();
        hashMap.put('(', ')');
        if(p.equals("")) return p;

        divide(p);


        return answer.toString();
    }
    public static void divide(String s){
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        Stack<java.lang.Character> stack = new Stack<>();
        for (int i = 0; i < p.length(); i++) {
            if(hashMap.containsKey(p.charAt(i))){
                stack.push(p.charAt(i)); // 여는 괄호면 넣고
            }else {
                if(!stack.isEmpty()){
                    stack.pop();
                }else{ // pop하려 했는데 비어있다면
                    v.append(p.charAt(i));
                }

            }

            if(stack.isEmpty()){ // 스택이 비어졌다면
                for (int j = 0; j <= i; j++) {
                    u.append(p.charAt(j));
                }
            }
        }
        answer.append(u);
//        divide(v.toString());

    }

}
