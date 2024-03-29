import java.util.ArrayList;
import java.util.Arrays;

public class LineUp {
    public static int n = 4;
    public static long k = 8;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(n, k)));
    }

    public static int[] solution(int n, long k){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] answer = new int[n];

        long factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
            arrayList.add(i);
        }

        int idx = 0;
        k--;
        while (n>0){
            factorial = factorial / n;
            answer[idx++] = arrayList.get((int)(k/factorial));
            arrayList.remove((int)(k/factorial));
            k = k % factorial;
            n--;
        }

        return answer;
    }
}
