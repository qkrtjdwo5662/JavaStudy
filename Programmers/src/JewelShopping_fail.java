import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class JewelShopping_fail {
    public static String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(gems)));
    }

    public static int[] solution(String[] gems){
        HashSet<String> hashSet = new HashSet<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < gems.length; i++) {
            hashSet.add(gems[i]);
        }

        int size = hashSet.size();
        int left = 0;
        int right = size;

        hashSet.clear();
        int index = 0;

        loop:
        while(true){
            left = 0;
            right = size+index;
            while(right <= gems.length){
                for (int i = left; i < right; i++) {
                    hashSet.add(gems[i]);
                }

                if(hashSet.size() == size) {
                    arrayList.add(left+1);
                    arrayList.add(right);
                    break loop;
                }
                left++;
                right++;
                hashSet.clear();
            }
            index++;
        }


        int[] answer = new int[2];

        for (int i = 0; i < 2; i++) {
            answer[i] = arrayList.get(i);
        }


        return answer;
    }
}
