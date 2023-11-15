package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_1234 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = 10;

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            ArrayList<Integer> list = new ArrayList<>();

            for (int j = 0; j < len; j++) {
                list.add(s.charAt(j) - '0');
            }
            while(true){
                boolean flag = true;
                for (int j = 0; j < list.size()-1; j++) {
                    if(list.get(j) == list.get(j+1)){
                        list.remove(j);
                        list.remove(j);
                        flag = false;
                    }
                }
                if(flag) break;
            }

            StringBuilder answer = new StringBuilder();
            for (int j = 0; j < list.size(); j++) {
                answer.append(list.get(j));
            }

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);

    }
}
