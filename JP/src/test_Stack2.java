import java.util.ArrayDeque;

public class test_Stack2 {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i <= 3; i++) {
            stack.addLast(i);
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pollLast());
        }
    }
}
