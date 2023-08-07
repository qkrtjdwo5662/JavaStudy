import java.util.HashMap;

public class Test {

    public static void main(String[] args) {

        HashMap<String, boolean[]> hashMap = new HashMap<>();
        boolean[] a = new boolean[19];
        a[0] = true;
        hashMap.put("a", a);
        a[1] = true;
        hashMap.put("a", a);
    }
}
