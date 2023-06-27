import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> A = new HashMap<>();
        HashMap<Integer, Integer> B = new HashMap<>();
        HashMap<Integer, Integer> Common = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
             A.put(Integer.parseInt(st.nextToken()), 0);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B.put(Integer.parseInt(st.nextToken()), 0);
        }


        for(int key: A.keySet()){
            if(B.containsKey(key)){
                Common.put(key,0);
            }
        }

        for(int key: Common.keySet()){
            A.remove(key);
            B.remove(key);
        }

        int answer = A.size() + B.size();
        System.out.println(answer);
    }
}
