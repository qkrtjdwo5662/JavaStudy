import java.util.ArrayDeque;

public class Deque {
    public static void main(String[] args) {
        ArrayDeque<Integer>deque = new ArrayDeque<>();

        //queue
        deque.addLast(1);
        deque.addLast(3);
        deque.addLast(5);
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());

        //stack
        deque.addLast(1);
        deque.addLast(3);
        deque.addLast(5);
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());
    }
}
