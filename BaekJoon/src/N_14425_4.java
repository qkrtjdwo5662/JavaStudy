import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N_14425_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <n ; i++) {
            String s = br.readLine();
            set.add(s);
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if(set.contains(s)) answer++;
        }

        System.out.println(answer);
    }
}
