import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int max = n;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while(right < max){
            sum = sum + arr[right]; // 누적 합

             right = right + 1;
            while(s <= sum){
                if(right - left < min){
                    min = right - left ;
                }

                sum = sum - arr[left];
                left++;
            }
        }
        if(min == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);
    }
}
