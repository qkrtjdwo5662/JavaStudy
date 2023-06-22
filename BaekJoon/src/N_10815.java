import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());


        HashMap<Integer, Integer> hashMap = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            hashMap.put(Integer.parseInt(st.nextToken()),0);
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int card = Integer.parseInt(st.nextToken());
            if(hashMap.containsKey(card)) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.print(sb);
    }
}
