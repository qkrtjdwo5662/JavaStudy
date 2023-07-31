import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1645 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        long n = Long.parseLong(st.nextToken());

        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        binarySearch(arr, n);
    }

    public static void binarySearch(int[] arr, long n){
        long left = 1;
        long right = arr[arr.length-1];

        while(left <= right){
            long mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum = sum + (arr[i]/mid);
            }
            if(sum < n){
                right = mid-1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(right);

    }
}
