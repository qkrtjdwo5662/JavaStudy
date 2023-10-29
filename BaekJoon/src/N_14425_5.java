import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class N_14425_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<String> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            list.add(s);
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if(list.contains(s)) answer++;
        }

        System.out.println(answer);
    }
}
