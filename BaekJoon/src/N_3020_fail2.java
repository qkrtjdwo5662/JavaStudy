import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_3020_fail2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] answer = new int[h+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int data = Integer.parseInt(st.nextToken());
            if(i%2 != 0){
                for (int j = 1; j <= data; j++) {
                    answer[j]++;
                }
            }else{
                for (int j = h; j > h-data; j--) {
                    answer[j]++;
                }
            }
        }

        int min= Integer.MAX_VALUE;
        for (int i = 1; i <= h ; i++) {
            min = Math.min(answer[i], min);
        }

        int count = 0;
        for (int i = 1; i <= h ; i++) {
            if(answer[i] == min) count++;
        }

        System.out.println(min + " " + count);
    }
}
