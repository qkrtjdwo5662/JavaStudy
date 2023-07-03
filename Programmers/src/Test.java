import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(5);
        System.out.println(arrayList);


        arrayList.remove(Integer.valueOf(1));
        System.out.println(arrayList);
    }
}
