package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N_15612 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        loop: // loop로 넘기면 입력을 덜 받게 됨 -> set으로는 통과
        for (int i = 1; i <= tc ; i++) {
            int total = 0;

            HashSet<Integer> col = new HashSet<>(); // 열 중복체크
            HashSet<Integer> row = new HashSet<>();
            for (int j = 0; j < 8; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();

                for (int k = 0; k < s.length(); k++) {
                    if(s.charAt(k) == 'O'){
                        total = total + 1;
                        col.add(k);
                        row.add(j);
                    }
                }

            }

            if(total != 8){
                sb.append("#").append(i).append(" ").append("no").append("\n");
                continue;
            }

            if(col.size() != 8){
                sb.append("#").append(i).append(" ").append("no").append("\n");
                continue;
            }

            sb.append("#").append(i).append(" ").append("yes").append("\n");
        }
        System.out.println(sb);

    }
}
