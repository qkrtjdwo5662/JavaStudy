import java.util.HashMap;

public class Phoneketmon {
    public static int[] nums = {3,3,3,2,2,4};
    public static void main(String[] args) {
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums){
        int answer = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])){
                hashMap.put(nums[i], hashMap.get(nums[i])+1);
            }else hashMap.put(nums[i],1);
        }

        int n = nums.length/2;

        if(hashMap.size()>=n){
            answer = n;
        }else answer = hashMap.size();

        return answer;
    }
}
