import java.util.ArrayDeque;

public class Deque {
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for (int i = 1; i <= 5; i++) {
            arrayDeque.addLast(i);
        }

        System.out.println(arrayDeque.pollLast());
        System.out.println(arrayDeque.pollFirst());
        System.out.println(arrayDeque.pollLast());
        System.out.println(arrayDeque.pollFirst());
        System.out.println(arrayDeque.pollFirst());
    }
}
