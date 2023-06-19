import java.util.ArrayList;
import java.util.HashMap;

public class Boost1 {
    public static int[] arr = {3,5,7,9,1};

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length ; i++) {
            if(hashMap.containsKey(arr[i])){
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            }else {
                hashMap.put(arr[i], 0);
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int key: hashMap.keySet()){
            if(hashMap.get(key) !=0 ) arrayList.add(hashMap.get(key)+1);
        }

        if(arrayList.size() == 0) arrayList.add(-1);
        System.out.println(arrayList);

    }
}
