import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] top = new int[h+1];
        int[] bottom = new int[h+1];

        for (int i = 0; i < n/2; i++) {
            int top_data = Integer.parseInt(br.readLine());
            int bottom_data = Integer.parseInt(br.readLine());
            
            top[top_data]++;
            bottom[bottom_data]++;
        }

        for (int i = h-1; i >0 ; i--) {
            top[i] = top[i+1] + top[i];
            bottom[i] = bottom[i+1] + bottom[i];
        }


        int[] answer = new int[h+1];
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= h ; i++) {
            answer[i] =  bottom[i] + top[h-i + 1];
            min = Math.min(answer[i], min);
        }

        int count = 0;
        for (int i = 1; i <= h; i++) {
            if(min == answer[i]) count++;
        }

        System.out.println(min + " " +count);
    }
}
