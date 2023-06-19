import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test {
    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        ArrayDeque<Integer> test = new ArrayDeque<>();

        arrayDeque.addFirst(1);
        arrayDeque.addFirst(2);
        arrayDeque.addFirst(3);

        test.addLast(1);
        test.addLast(1);
        test.addLast(1);

        test = arrayDeque;

        System.out.println(test);


    }
}
