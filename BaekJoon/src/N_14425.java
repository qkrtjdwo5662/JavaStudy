import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n ; i++) {
            hashMap.put(br.readLine(), 0);
        }

        for (int i = 0; i < m; i++) {
            if(hashMap.containsKey(br.readLine())){
                count ++;
            }
        }
        System.out.println(count);

    }
}
