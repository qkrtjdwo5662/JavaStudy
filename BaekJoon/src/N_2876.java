import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_2876 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        int[] temp = new int[6]; // 1 ~ 5 grade 개수
        int[] dp = new int[6]; // 1 ~ 5 grade 연속 최대치 개수

        int tempA = arr[0][0];
        int tempB = arr[0][1];


        if(tempA != tempB){
            temp[tempA] ++;
            temp[tempB] ++;

            dp[tempA] ++;
            dp[tempB] ++;
        }else{
            temp[tempA] ++;
            dp[tempA] ++;
        }

        int max = 1;

        for (int i = 1; i < n; i++) {
            int A = arr[i][0];
            int B = arr[i][1];


            if(tempA == A || tempA == B) {
                temp[tempA] ++;
                max = Math.max(max, temp[tempA]);
                dp[tempA] = Math.max(dp[tempA], temp[tempA]);
            }else{
                temp[tempA] = 0;
                temp[A] ++;
                tempA = A;
            }

            if(tempA == tempB) {
                if(A != B) temp[B] ++;
                tempB = B;
                continue; // 이미 카운트 증가 시켰음
            }

            if(tempB == A || tempB == B) {
                temp[tempB] ++;
                max = Math.max(max, temp[tempB]);
                dp[tempB] = Math.max(dp[tempB], temp[tempB]);
            }else{
                temp[tempB] = 0;
                if(A != B) temp[B] ++;
                tempB = B;
            }
        }

        int grade = 0;
        for (int i = 1; i <= 5 ; i++) {
            if(max == dp[i]){
                grade = i;
                break;
            }
        }

        sb.append(max).append(" ").append(grade).append("\n");
        System.out.println(sb);
    }
}
