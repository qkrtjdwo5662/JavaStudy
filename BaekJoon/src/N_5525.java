import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String s = st.nextToken(); // 원본

        StringBuilder compare = new StringBuilder("IOI");
        for (int i = 1; i < n ; i++) {
            compare.append("OI");
        }

        String compareString = compare.toString();
        int answer = 0;

        // 10101 10
        for (int i = 0; i < m - compareString.length() + 1; i++) {
            if(s.substring(i, i + compareString.length()).equals(compareString)) answer ++;
        }

        sb.append(answer).append("\n");
        System.out.println(sb);

    }
}
