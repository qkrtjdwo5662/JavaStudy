import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] buildings = new int[w];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int max_left = 0;
        int max_right = 0;
        for (int i = 1; i < w-1; i++) {
            max_left = 0;
            max_right = 0;
            for (int j = 0; j < i; j++) {
                max_left = Math.max(max_left, buildings[j]);
            }

            for (int j = i+1; j < w; j++) {
                max_right = Math.max(max_right, buildings[j]);
            }

            int rain = Math.min(max_left, max_right) - buildings[i];
            if(rain<=0) rain = 0;
            answer = answer + rain;
        }
        System.out.println(answer);
    }
}
