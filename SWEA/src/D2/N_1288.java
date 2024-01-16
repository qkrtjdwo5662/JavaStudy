package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N_1288 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            HashSet<Integer> set = new HashSet<>();
            int index = 1;
            while(set.size() != 10){
                int num = index * n;
                String numString = String.valueOf(num);

                for (int j = 0; j < numString.length(); j++) {
                    int numChar = numString.charAt(j) - '0';
                    if(!set.contains(numChar)){
                        set.add(numChar);
                    }
                }
                index ++;
            }
            sb.append("#").append(i).append(" ").append(n*(index - 1)).append("\n");
        }
        System.out.println(sb);
    }
}
