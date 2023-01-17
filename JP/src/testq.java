import java.util.ArrayDeque;
import java.util.Queue;

public class testq {
    private static final int MAX = 300_000;
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(1);
        queue.add(3);
        queue.add(5);

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
        

    }
}
