import java.util.ArrayDeque;
import java.util.Stack;

public class RightBracket2 {
    public static void main(String[] args) {
        String s = "}]()[{";
        System.out.println(solution(s));
    }

    static int solution(String s){
        int answer = 0;
        ArrayDeque<java.lang.Character> queue = new ArrayDeque<>();
        Stack<java.lang.Character> stack = new Stack<>();

        int n = 0;

        while(n!=s.length()) {
            for (int i = 0; i < s.length(); i++) {
                queue.addLast(s.charAt(i));
            }
            for (int i = 0; i < n; i++) {
                queue.addLast(queue.pollFirst());//회전
            }
            if (queue.getFirst() == '(' || queue.getFirst() == '[' || queue.getFirst() == '{') {
                stack.push(queue.pollFirst());
            } else {
                queue.pollFirst();
                if(stack.isEmpty()){
                    continue;
                }else stack.pop();
            }

            if (stack.isEmpty()) {
                answer++;
            }
            n++;
        }

        return answer;
    }
}
