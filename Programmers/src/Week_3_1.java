import java.util.Stack;

public class Week_3_1 {

    public static String s = "()()";

    public static void main(String[] args) {
        System.out.println(solution(s));
    }

    public static boolean solution(String s){
        boolean answer = true;
        Stack<java.lang.Character> stack = new Stack<>();

        // 여는 괄호 -> push
        // 닫는 괄호 -> pop

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){ // 여는 괄호
                stack.push(s.charAt(i));
            }else{ // 닫는괄호 -> pop
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty()) return false;


        return answer;
    }
}
