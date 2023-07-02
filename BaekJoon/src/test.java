import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class test {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        treeMap.put(1,1);
        treeMap.put(2,1);
        treeMap.put(3,1);

        System.out.println(treeMap.containsKey(4));
    }
}
