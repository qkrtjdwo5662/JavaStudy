import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N_10816_Hash {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        HashMap<Integer,Integer> sgCard = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            if(sgCard.containsKey(k)){
                sgCard.put(k,sgCard.get(k)+1);
            }else sgCard.put(k,1);
            continue;
        }

        st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(st.nextToken());
            if(sgCard.containsKey(k)){
                sb.append(sgCard.get(k)).append(" ");
            }else sb.append(0).append(" ");
        }

        System.out.println(sb);

    }
}
