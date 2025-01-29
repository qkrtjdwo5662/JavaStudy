import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_13397_3 {
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

        int answer = 0; // answer가 구간의 최댓값이 될 수 있는가?

        while(left <= right){
            int mid = (left + right) / 2;

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int count = 1;
            for (int i = 0; i < n; i++) {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);

                int abs = Math.abs(max - min);

                if(mid < abs) {
                    min = Integer.MAX_VALUE;
                    max = Integer.MIN_VALUE;
                    count ++;
                    i --;
                }
            }

            if(count <= m){ // 구간의 갯수가 작거나 같을 수 있음 (부합한다면?)
                answer = mid; // 최신화
                right = mid - 1;
            }else left = mid + 1;
        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }
}
