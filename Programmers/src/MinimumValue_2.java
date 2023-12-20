import java.util.Arrays;

public class MinimumValue_2 {
    public static int[] A = {1, 2};
    public static int[] B = {3, 4};
    public static void main(String[] args) {
        System.out.println(solution(A, B));
    }

    public static int solution(int[] A, int[] B){
        int answer = 0;

        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);


        for (int i = 0; i < n; i++) {
            answer = answer + A[i]*B[n-i-1];
        }

        return answer;
    }
}
