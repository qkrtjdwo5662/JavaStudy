import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2559_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int data = Integer.parseInt(st.nextToken());
            arr[i] = arr[i-1] + data;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= n-k ; i++) {
            sum = arr[i+k] - arr[i];
            max = Math.max(max, sum);
        }

        System.out.println(max);

    }
}
