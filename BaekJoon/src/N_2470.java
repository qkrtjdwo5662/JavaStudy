import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        int right = n-1;

        int start = 0;
        int end = n-1;
        while(left < right){
            sum = arr[left] + arr[right];
            if(Math.abs(sum) < min) {
                min = Math.min(min, Math.abs(sum));
                start = left;
                end = right;

            }
            if(sum > 0){
                right--;
            }else{
                left++;
            }
        }

        System.out.println(arr[start] + " " + arr[end]);
    }
}
