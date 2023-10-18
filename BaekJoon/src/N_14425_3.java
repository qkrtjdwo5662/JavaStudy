import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_14425_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<String> arrayList = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            arrayList.add(s);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(arrayList.contains(s)) {

                answer++;
            }
        }


        System.out.println(answer);
    }
}
