import java.util.Arrays;

public class LineUp {
    public static int n = 5;
    public static long k = 18;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(n, k)));
    }

    public static int[] solution(int n, long k){
        // 범위를 통해 하나씩 찾아나간다.

        // ex) n=5

        // 총 120개 5x4x3x2x1
        // 1 ~ 24    answer[0] : 1
        // 25 ~ 48   answer[0] : 2
        // 49 ~ 72   answer[0] : 3
        // 73 ~ 96   answer[0] : 4
        // 97 ~ 120  answer[0] : 5

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            long factorial = 1;
            for (int j = 1; j < n-i; j++) {
                factorial = j * factorial;
            }
            answer[i] = (int) ((int)k/factorial + 1);
            k = k - (answer[i]-1) * factorial;

            System.out.println(factorial + " " + k);
        }

        return answer;
    }
}
