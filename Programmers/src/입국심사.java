import java.util.Arrays;

public class 입국심사 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }

    public static long solution(int n, int[] times){
        long answer = 0;


        long left = 1;

        Arrays.sort(times);
        long right = (long) n *times[0];

        while(left <= right){
            long mid = (left + right) / 2;

            long count = 0;
            for (int i = 0; i < times.length; i++) {
                count += mid / times[i];
            }

            if(count < n){
                left = mid + 1;
            }else {
                answer = mid;
                right = mid - 1;
            }
        }

        return answer;
    }
}
