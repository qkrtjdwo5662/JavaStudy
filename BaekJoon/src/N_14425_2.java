import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N_14425_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            set.add(s);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(set.contains(s)) {

                answer++;
            }
        }


        System.out.println(answer);
    }
}
