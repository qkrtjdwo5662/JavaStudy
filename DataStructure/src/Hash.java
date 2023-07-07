import java.util.HashMap;

public class Hash {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 1; i <= 5; i++) {
            hashMap.put(i, 0);
        }

        System.out.println(hashMap);
    }
}
