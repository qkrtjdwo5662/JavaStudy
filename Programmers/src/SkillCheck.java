import java.util.Arrays;

public class SkillCheck {
    public static int n = 3;
    public static long left = 2;
    public static long right = 5;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(n, left, right)));
    }
    public static int[] solution(int n, long left, long right){
        int count = 0;

        int[] answer = new int[(int) (right - left + 1)];

        for (int i = 1; i <= n*n; i++) {
            int num = 1; // i == 1 일 때,

            if((i-1)%(n+1) ==0){ // 가운데
                num = ((i-1)/(n+1)) + 1;
            } else if (i%n == 0) {
                num = n;
            } else if (i<=n){
                num = i;
            }


            if(left <= count && count <= right){
                answer[(int) (count-left)] = num;
            }
        }



        return answer;

    }
}
