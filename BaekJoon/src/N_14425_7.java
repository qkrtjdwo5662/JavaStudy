import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N_14425_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            map.put(s, 0);
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();

            if(map.containsKey(s)) answer++;
        }

        System.out.println(answer);
    }
}
