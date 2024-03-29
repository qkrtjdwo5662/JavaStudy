import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] distance = new int[n-1];
        int[] price = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }


        long answer = 0;
        int min = price[0];

        for (int i = 0; i < n-1; i++) {
            if(min > price[i]) min = price[i];

            answer = answer + (long) min * distance[i];

        }



        System.out.println(answer);
    }
}
