import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N_17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            if(hashMap.containsKey(k)){
               hashMap.put(k, hashMap.get(k)+1);
               continue;
            }
            hashMap.put(k,1);
        }

    }
}
