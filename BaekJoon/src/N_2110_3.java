import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_2110_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        Arrays.sort(arr);
        int left = 1;
        int right = arr[n - 1];

        int answer = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            int count = 1;
            int temp = arr[0];
            for (int i = 1; i < n; i++) {
                if(arr[i] - temp >= mid) {

                    count++;
                    temp = arr[i];
                }
            }

            if(count >= c){
                left = mid + 1;
                answer = mid;
            }else{
                right = mid - 1;
            }
        }
        sb.append(answer).append("\n");
        System.out.println(sb);


    }
}
