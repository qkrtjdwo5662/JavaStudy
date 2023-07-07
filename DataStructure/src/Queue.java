import java.util.ArrayDeque;

public class Queue {
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for (int i = 1; i <= 5 ; i++) {
            arrayDeque.addLast(i);
        }

        while(!arrayDeque.isEmpty()){
            System.out.println(arrayDeque.pollFirst());
        }
    }
}
