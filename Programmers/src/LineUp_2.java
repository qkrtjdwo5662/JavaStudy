import java.util.ArrayList;
import java.util.Arrays;

public class LineUp_2 {
    public static int n = 4;
    public static long k = 8;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(n, k)));
    }
    public static int[] solution(int n, long k){
        int[] answer = new int[n];
        ArrayList<Integer> arrayList = new ArrayList<>();

        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
            arrayList.add(i);
        }

        k = k - 1;
        int index = 0;
        while(n > 0){
            factorial = factorial / n;
            answer[index] = arrayList.get((int) (k / factorial));
            arrayList.remove((int) (k / factorial));
            index = index + 1;
            k = k % factorial;
            n = n-1;
        }

        return answer;
    }
}
