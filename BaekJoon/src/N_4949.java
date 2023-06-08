import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String s = br.readLine();
            if(s.charAt(0)=='.'){
                break;
            }
            boolean check = false;
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                //[ or ( 일 때는 push
                if(s.charAt(i)=='[' || s.charAt(i)=='('){
                    stack.push(s.charAt(i));
                    //s의 문자열 원소가 ) 일 때, 스택의 peek가 ( 이고, 스택이 비어있지 않을 때
                }else if(s.charAt(i)==')' && (!stack.isEmpty() &&stack.peek() =='(' )) {
                    stack.pop();
                    //s의 문자열 원소가 ] 일 때, 스택의 peek가 [ 이고, 스택이 비어있지 않을 때
                } else if (s.charAt(i)==']'&& (!stack.isEmpty() && stack.peek() =='[')) {
                    stack.pop();
                    //s의 문자열 원소가 ] 일 때, 스택의 peek가 [가 아니고, 스택이 비어있지 않을 때
                } else if (s.charAt(i)==']' && (!stack.isEmpty() && stack.peek() !='[')) {
                    sb.append("no").append("\n");
                    check = true;
                    break;
                    //s의 문자열 원소가 ) 일 때, 스택의 peek가 (가 아니고, 스택이 비어있지 않을 때
                }else if (s.charAt(i)==')' && (!stack.isEmpty() && stack.peek() !='(')) {
                    sb.append("no").append("\n");
                    check = true;
                    break;
                    //s의 문자열 원소가 ) 또는 ] 이며, 스택이 비어 있을 때
                }else if ((s.charAt(i)==')' || s.charAt(i)==']') && stack.isEmpty()) {
                    sb.append("no").append("\n");
                    check = true;
                    break;
                }
            }
            if(check){ // check가 true면 밑의 조건문 생략
                continue;
            }

            if(stack.isEmpty()){
                sb.append("yes").append("\n");
            }else sb.append("no").append("\n");
        }
        System.out.print(sb);
    }
}
