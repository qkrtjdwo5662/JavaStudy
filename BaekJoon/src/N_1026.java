import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] first = new int[n];
        int[] second = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            first[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            second[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(first);
        Arrays.sort(second);

        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer = answer + first[i] * second[n-1-i];
        }

        System.out.println(answer);

    }
}
