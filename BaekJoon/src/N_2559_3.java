import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2559_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = k;

        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum = sum + arr[i];
        }

        int answer = sum;

        while(r<n){
            sum = sum - arr[l];
            sum = sum + arr[r];

            answer = Math.max(answer, sum);
            l++;
            r++;
        }
        System.out.println(answer);

    }
}
