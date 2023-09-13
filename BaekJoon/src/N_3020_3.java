import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_3020_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] arr = new int[h+1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int data = Integer.parseInt(st.nextToken());

            if(i%2==0){
                for (int j = 1; j <= data; j++) {
                    arr[j] = arr[j] + 1;
                }
            }else{
                for (int j = h; j > h-data; j--) {
                    arr[j] = arr[j] +1;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 1; i <= h; i++) {
            min = Math.min(min, arr[i]);
        }

        for (int i = 1; i <=h ; i++) {
            if(arr[i] == min) count++;
        }

        System.out.println(min + " " +count);
    }
}
