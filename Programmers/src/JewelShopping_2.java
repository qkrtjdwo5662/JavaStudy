import java.util.Arrays;
import java.util.HashMap;

public class JewelShopping_2 {
    public static String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(gems)));
    }

    public static int[] solution(String[] gems){
        HashMap<String, Integer> map = new HashMap<>();
        for (String gem : gems) {
            map.put(gem, 0);
        }
        int max = map.size();

        int left = 0;
        int right = 0;
        int start =1;
        int end = gems.length;
        int min = gems.length;
        map.clear();
        while(right < gems.length){
            if(map.containsKey(gems[right])){
                int count = map.get(gems[right]);
                map.put(gems[right], count+1);
            }else{
                map.put(gems[right], 1);
            }

            right = right +1;

            while(map.size() == max){ // 사이즈가 같아지면
                if(right - left < min){
                    min = right - left;
                    start = left +1;
                    end = right;
                }
                int count = map.get(gems[left]);

                if(count -1 ==0){
                    map.remove(gems[left]);
                }else{
                    map.put(gems[left], count-1);
                }
                left = left +1;

            }
        }



        return new int[]{start, end};
    }
}
