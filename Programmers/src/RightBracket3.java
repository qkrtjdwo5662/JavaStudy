import java.util.Stack;

public class RightBracket3 {
//    public static String[] s =  {"()()", "(())()",")()(","(()("};

    public static String s = "()()";
//    public static String s = "(())()";
//    public static String s = ")()(";
//    public static String s = "(()(";

    public static void main(String[] args) {
        System.out.println(solution(s));
    }
    public static boolean solution(String s){
        boolean answer = true;
        Stack<java.lang.Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (!stack.isEmpty() && s.charAt(i)==')') {
                stack.pop();
            } else if (stack.isEmpty() && s.charAt(i)==')') {
                answer = false;
                break;
            }
        }
        
        if(!stack.isEmpty()){
            answer = false;
        }


        return answer;
    }
}
