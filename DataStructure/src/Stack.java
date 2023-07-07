import java.util.ArrayDeque;

public class Stack {
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for (int i = 1; i <= 5; i++) {
            arrayDeque.addFirst(i);
        }

        while(!arrayDeque.isEmpty()){
            System.out.println(arrayDeque.pollFirst());
        }

    }
}
