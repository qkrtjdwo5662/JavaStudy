import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_13397_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int left = 0;
        int right = 10_000;

        int answer = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            int count = 1;
            int min = 10_000;
            int max = 1;
            for (int i = 0; i < n; i++) {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);

                if(max - min > mid){
                    count ++;
                    min = 10_000;
                    max = 1;
                    i --;
                }
            }
            if(count <= m){
                right = mid - 1;
                answer = mid;
            }else left = mid + 1;
        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }
}
