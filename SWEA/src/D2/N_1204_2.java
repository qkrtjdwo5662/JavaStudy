package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N_1204_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            HashMap<Integer, Integer> map = new HashMap<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 1000 ; j++) {
                int grade = Integer.parseInt(st.nextToken());
                if(map.containsKey(grade)){
                    map.put(grade, map.get(grade) + 1);
                }else{
                    map.put(grade, 1);
                }
            }
            ArrayList<Integer> list = new ArrayList<>();
            int max = 0;
            for(int key: map.keySet()){
                max = Math.max(max, map.get(key));
            }

            int answer =0;
            for(int key : map.keySet()){
                if(max == map.get(key)) answer = key;
            }

            Collections.sort(list);

            sb.append("#").append(t).append(" ").append(answer).append("\n");

        }
        System.out.println(sb);
    }
}
