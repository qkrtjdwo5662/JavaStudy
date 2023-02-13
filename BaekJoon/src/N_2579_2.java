import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2579_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        total = total + arr[0] + arr[n-1];

        if(n%2==0){
            for (int i = 1; i < n/2; i++) {
                total = total + Math.max(arr[2*i-1],arr[2*i]);
            }
        }else{
            for (int i = 1; i < n/2+1; i++) {
                total = total + Math.max(arr[2*i-1],arr[2*i]);
            }
        }


        System.out.println(total);
    }
}
