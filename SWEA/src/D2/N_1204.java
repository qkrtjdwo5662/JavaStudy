package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N_1204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int j = 1; j <= 1000 ; j++) {
                int score = Integer.parseInt(st.nextToken());

                if(map.containsKey(score)){
                    map.put(score, map.get(score) + 1);
                    continue;
                }
                map.put(score, 1);
            }

            int maxCount = 0;
            int maxScore = 0;
            for (int key : map.keySet()){
                maxCount = Math.max(maxCount, map.get(key));
            }

            for (int key : map.keySet()) {
                if(map.get(key) == maxCount){
                    maxScore = Math.max(maxScore, key);
                }
            }

            sb.append("#").append(num).append(" ").append(maxScore).append("\n");
        }
        System.out.println(sb);
    }
}
