import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class Hash {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        // Thread-Safe

        HashMap<String, Integer> map = new HashMap<>();
        // None-Thread-Safe
        map.put("박철수", 111111);
        map.put("김짱구", 222222);

        System.out.println(map.get("박철수"));// O(1)
        System.out.println(map.size()); // O(1)

        Hashtable<String, Integer> table = new Hashtable<>();
        // Thread-Safe
    }
}
