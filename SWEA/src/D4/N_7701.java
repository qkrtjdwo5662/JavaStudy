package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_7701 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            ArrayList<String> list = new ArrayList<>();
            HashSet<String> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();

                if(!set.contains(s)){
                    set.add(s);
                    list.add(s);
                }

            }
            Collections.sort(list, ((o1, o2) -> {
                if(o1.length() < o2.length()){
                    return o1;
                }else if(o1.length() > o2.length()){
                    return o2;
                }else{
                    if(compare(o1, o2) == 0){
                        return o1;
                    }else return o2;
                }
            }));

            sb.append("#").append(i).append("\n");
            for (int j = 0; j < list.size(); j++) {
                sb.append(list.get(j)).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int compare(String s1, String s2){
        int n = s1.length();
        for (int i = 0; i < n ; i++) {
            int a = s1.charAt(i) - '0';
            int b = s2.charAt(i) - '0';

            if(a < b){
                return 0;
            }else if(a > b){
                return 1;
            }
        }

        return 1;
    }
}
