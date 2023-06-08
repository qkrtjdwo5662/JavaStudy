import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

public class test {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

//        while(!stack.isEmpty()){
//            System.out.println(stack.peek());
//            System.out.println(stack.pop());
//        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        hashMap.put(1,1);

        hashMap.put(1,hashMap.get(1)+1);

        System.out.println(hashMap.get(1));

    }
}
