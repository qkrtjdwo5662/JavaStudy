import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1920_BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        st = new StringTokenizer(br.readLine());
        int m =  Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(st.nextToken());
            sb.append(BinarySearch(arr, k)).append("\n");
        }
        System.out.print(sb);

    }
    public static int BinarySearch(int [] arr, int n){
        int left = 0;
        int right = arr.length-1;

        while(left < right){
            int mid = (left + right)/2;
            if(n<=arr[mid]) {
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        if(arr[left]==n){
            return 1;
        }else return 0;

    }
}
