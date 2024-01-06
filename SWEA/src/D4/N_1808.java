package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_1808 {
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    list.add(j);
                }
            }
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());

            answer = Integer.MAX_VALUE;
            dfs(target, list, 0);
            if(answer == Integer.MAX_VALUE){
                sb.append("#").append(i).append(" ").append(-1).append("\n");
            }else{
                sb.append("#").append(i).append(" ").append(answer).append("\n");
            }

        }
        System.out.println(sb);
    }

    public static void dfs(int now, ArrayList<Integer> list, int count){
        if(count > answer) return;

        if(check(now, list)){
            int len = String.valueOf(now).length();
            answer = Math.min(answer, count + len + 1);
            return;
        }

        for (int i = (int)Math.sqrt(now); i >1 ; i--) {
            if(now % i == 0 && check(i, list)){
                int len = String.valueOf(i).length();
                dfs(now/i, list, count + len + 1);
            }
        }

    }

    public static boolean check(int now, ArrayList<Integer> list){
        String s = String.valueOf(now);
        for (int i = 0; i < s.length(); i++) {
            if(!list.contains(s.charAt(i) - '0')){
                return false;
            }
        }

        return true;
    }
}
