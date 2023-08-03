import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 규칙 정리
        // 0 단계 : 2^2 = 4
        // 0 + 4

        // 1 단계 : 3^2 = 9
        // 4 + 5*1 - 0

        // 2 단계 : 5^2 = 25
        // 9 + (5*4 - 4)

        // 3단계 : 9^2 = 81
        // 25 + (5*16 - 24) = 81

        // 0 : 2
        // 1 : 3
        // 2 : 5
        // 3 : 9
        // 4 : 17

        int[] arr = new int[n+1];

        arr[0] = (int)Math.pow(2, 2);
        arr[1] = (int)Math.pow(3, 2);
        arr[2] = (int)Math.pow(5, 2);
        for (int i = 3; i < n+1; i++) {
            arr[i] = (int)Math.sqrt(arr[i-1]) + (int)Math.pow(2, i-1);
            arr[i] = (int)Math.pow(arr[i],2);
        }

        System.out.println(arr[n]);

    }
}
