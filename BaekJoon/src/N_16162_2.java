import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_16162_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int[] dp = new int[n];

        int temp = 0;
        if(arr[0] == a) {
            dp[0] = 1;
            temp = a;
        }

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];

            if(dp[i] == 0 && arr[i] == a) {
                dp[i] = 1;
                temp = a;
            }else if(dp[i] != 0 && arr[i] == temp + d){
                dp[i] ++;
                temp = temp + d;
            }
        }

        System.out.println(dp[n - 1]);
    }
}
