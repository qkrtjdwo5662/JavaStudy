import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int index = -1;
        while(k>0){
            for (int i = n-1; i >=0 ; i--) {
                if(arr[i]<=k){
                    index = i;
                    break;
                }
            }
            while(k-arr[index] >= 0){
                k = k - arr[index];
                count++;
            }
        }
        System.out.println(count);
    }
}
