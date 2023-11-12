package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int k = 0; k < n; k++) {
                    arr[j][k] = s.charAt(k) - '0';
                }
            }

            int answer = 0;
            int middle = n/2;

            for (int j = 0; j < middle; j++) {
                for (int k = middle-j; k <= middle+j; k++) {
                    answer += arr[j][k];
                }
            }

            for (int j = n; j > middle ; j--) {
                for (int k = middle-(n-1-j); k <= middle+(n-1-j); k++) {
                    answer += arr[j][k];
                }
            }

            for (int j = 0; j < n; j++) {
                answer += arr[middle][j];
            }

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);


    }
}
