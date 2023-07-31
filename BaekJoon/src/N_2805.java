import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_2805 {
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        binarySearch(m);
    }

    public static void binarySearch(long m){
        int left = 0;
        int right = arr[arr.length-1];

        while(left<=right){

            int mid = (left + right) /2;
            long sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]>mid) sum = sum + (arr[i] - mid);
            }

            if(sum < m){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(right);
    }
}
