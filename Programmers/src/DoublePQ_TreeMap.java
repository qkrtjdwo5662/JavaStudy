import java.util.Arrays;
import java.util.TreeMap;

public class DoublePQ_TreeMap {
    public static String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(operations)));
    }

    public static int[] solution(String[] operations){
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < operations.length; i++) {
            String[] operation = operations[i].split(" ");
            for (int j = 0; j < operation.length; j++) {
                String op = operation[0];
                int num = Integer.parseInt(operation[1]);
                if(op.equals("I")){ // 명령어 I
                    if(treeMap.containsKey(num)){
                        treeMap.put(num, treeMap.get(num) + 1);
                    }else{
                        treeMap.put(num, 1);
                    }
                }else{ // 명령어 D
                    if(treeMap.size() == 0) continue;

                    if(num == -1){ // 최솟값 삭제
                        treeMap.put(treeMap.firstKey(), treeMap.get(treeMap.firstKey())-1);
                        if(treeMap.get(treeMap.firstKey()) < 1) treeMap.remove(treeMap.firstKey());
                    }else{ // 최댓값 삭제
                        treeMap.put(treeMap.lastKey(), treeMap.get(treeMap.lastKey())-1);
                        if(treeMap.get(treeMap.lastKey()) < 1) treeMap.remove(treeMap.lastKey());
                    }
                }
            }
        }
        if(treeMap.size() == 0){
            return new int[]{0,0};
        }else{
            return new int[]{treeMap.lastKey(), treeMap.firstKey()};
        }

    }
}
