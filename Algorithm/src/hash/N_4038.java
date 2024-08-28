package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N_4038 {
    static HashMap<String, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            String B = st.nextToken();
            // "abracadabra"
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            // "ab"

            map = new HashMap<>();
            StringBuilder init = new StringBuilder();
            int len = S.length();

            for (int i = 0; i < len; i++) {
                init.append(B.charAt(i));
            }

            map.put(init.toString(), 1);

            while(len < B.length()){
                init.deleteCharAt(0);
                init.append(B.charAt(len));

                if(map.containsKey(init.toString())){
                    map.put( init.toString(), map.get(init.toString()) + 1);
                }else{
                    map.put(init.toString(), 1);
                }
                len ++;
            }

            sb.append("#").append(t).append(" ").append(map.get(S)).append("\n");
        }
        System.out.println(sb);
    }
}
