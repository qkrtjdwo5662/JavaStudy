import java.util.Stack;

public class RightBracket_2 {
    public static String s = "()()";
    public static void main(String[] args) {
        System.out.println(solution(s));
    }
    public static boolean solution(String s){

        Stack<java.lang.Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){ // '('
                stack.push(s.charAt(i));
            }else { // ')'
                if(stack.isEmpty()){
                    return false;
                }else {
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }else return false;

    }
}
