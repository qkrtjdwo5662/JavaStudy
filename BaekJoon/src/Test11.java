import java.util.PriorityQueue;
import java.util.TreeMap;

public class Test11 {
    public static int[] arr = {1, 2, 6, 3, 2, 1};
    public static void main(String[] args) {
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr){
        int answer =0;

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            if(treeMap.containsKey(arr[i])){
                treeMap.put(arr[i], treeMap.get(arr[i]) + 1);
            }else treeMap.put(arr[i], 1);
        }


        for (int i = 0; i < arr.length; i++) {
            if(treeMap.higherKey(arr[i]) != null){
                if(treeMap.get(treeMap.higherKey(arr[i])) > 0){
                    treeMap.put(treeMap.higherKey(arr[i]), treeMap.get(treeMap.higherKey(arr[i]))-1);
                    answer++;

                }else if(treeMap.get(treeMap.higherKey(arr[i])) == 0){
                    for (int key : treeMap.keySet()) {
                        if(key > arr[i] && treeMap.get(key)!= 0){
                            treeMap.put(key, treeMap.get(key) - 1);
                            answer++;
                        }
                    }
                }
            }
        }



        return answer;
    }
}
