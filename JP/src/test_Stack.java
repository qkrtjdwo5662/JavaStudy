import java.util.Stack;

public class test_Stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= 3; i++) {
            stack.push(i);
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
