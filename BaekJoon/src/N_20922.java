import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int[] count = new int[100001];
        int answer = 0;
        int start = 0;
        int end =0;

        while(end < arr.length){
            while(end < arr.length && count[arr[end]] + 1 <= k){
                count[arr[end]] += 1;
                end = end + 1;
            }

            int len = end - start;
            answer = Math.max(answer, len);
            count[arr[start]] -= 1;
            start = start + 1;
        }
        System.out.println(answer);
    }
}
