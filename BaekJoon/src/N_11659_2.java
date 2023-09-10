import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_11659_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(arr[end] - arr[start-1]).append("\n");
        }

//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int start = Integer.parseInt(st.nextToken());
//            int end = Integer.parseInt(st.nextToken());
//
//            int sum = 0;
//            for (int j = start; j <=end ; j++) {
//                sum = sum + arr[j];
//            }
//
//            sb.append(sum).append("\n");
//        }
        System.out.print(sb);


    }
}
