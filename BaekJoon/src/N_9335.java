import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_9335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        int n = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            String[] array = new String[a];
            for (int j = 0; j < array.length; j++) {
                array[j] = st.nextToken();
            }
        }

    }
}
