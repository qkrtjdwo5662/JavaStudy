//import java.util.Stack;
//
//public class RightBracket {
//    static String s = "(()(";
//    public static void main(String[] args) {
//        System.out.println(solution(s));
//    }
//    static boolean solution(String s){
//        boolean answer;
//        Stack<Character> stack = new Stack<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            if(s.charAt(i)=='('){
//                stack.push(s.charAt(i));
//            }else {
//                if(stack.isEmpty()){
//                    answer = false;
//                    return answer;
//                }else stack.pop();
//
//            }
//
//        }
//
//
//        answer = stack.isEmpty();
//
//
//        return answer;
//    }
//}
