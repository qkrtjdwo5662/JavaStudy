package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N_1221 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        map.put("ZRO", 0);
        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THR", 3);
        map.put("FOR", 4);
        map.put("FIV", 5);
        map.put("SIX", 6);
        map.put("SVN", 7);
        map.put("EGT", 8);
        map.put("NIN", 9);
        String[] numStrArr ={ "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                String numStr = st.nextToken();
                int num = map.get(numStr);

                arr[j] = num;
            }

            Arrays.sort(arr);
            sb.append("#").append(i).append("\n");
            for (int j = 0; j < n; j++) {
                String numStr = numStrArr[arr[j]];
                sb.append(numStr).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
