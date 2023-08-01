import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N_2725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        int[] answer = new int[1001];



        for (int i = 1; i <= 1000; i++) {
            int count =0;
            for (int j = 1; j <= i; j++) {
                int g = gcd(i, j);
                if(g==1) count++;
            }
            answer[i] = answer[i-1] + count;
        }

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(answer[n] * 2 + 1).append("\n");
        }
        System.out.print(sb);
        System.out.println(Arrays.toString(answer));
    }
    public static int gcd(int a, int b){
        int r = a % b;
        if(r==0) return b;
        else return gcd(b, r);
    }
}
