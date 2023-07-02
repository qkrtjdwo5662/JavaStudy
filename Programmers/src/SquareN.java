import java.util.Arrays;

public class SquareN {
    public static int n = 3;
    public static long left = 2;
    public static long right = 5;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(n, left, right)));
    }

    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        for (int i = 0; i < answer.length; i++) {
           int r = (int) ((i+left)/n) + 1;
           int c = (int) ((i+left)%n) + 1;

           answer[i] = Math.max(r,c);
        }

        return answer;
    }



}
