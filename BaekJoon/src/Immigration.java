public class Immigration {
    public static int n = 6;
    public static int[] times = {7, 10};
    public static int MAX = 1_000_000_000;
    public static void main(String[] args) {
        System.out.println(solution(n, times));
    }

    public static long solution(int n, int[] times) {

        long left = 0;
        long right = (long)MAX * MAX;

        while(left < right){
            long mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum = sum + mid/times[i];
            }

//            System.out.println("left : " +  left);
//            System.out.println("right : " +  right);
//            System.out.println("sum : " +  sum);
            if(sum < n){
                left = mid +1;
            }else right = mid;
        }


        return left;
    }
}
