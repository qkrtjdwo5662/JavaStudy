package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_1808_fail {
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st= new StringTokenizer(br.readLine());
            ArrayList<Integer> list=  new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                int num = Integer.parseInt(st.nextToken());

                if(num == 1) list.add(j);
            }

            st= new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            if(check(x, list)){
                sb.append("#").append(i).append(" ").append(1).append("\n");
                continue;
            }
            answer = Integer.MAX_VALUE;
            run(x, list, 1);
            if(answer == Integer.MAX_VALUE){
                sb.append("#").append(i).append(" ").append(-1).append("\n");
            }else sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);

    }

    public static void run(int now, ArrayList<Integer> list, int count){

        if(count > answer) return;

        if(check(now, list)){
            int len = String.valueOf(now).length();
            answer = Math.min(answer, count + len);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) ==0 || list.get(i) == 1) continue;

            if(now % list.get(i) == 0){
                run(now / list.get(i), list, count+2);
            }
        }



    }

    public static boolean check(int now, ArrayList<Integer> list){
        boolean flag = true;

        String s = String.valueOf(now);
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if(!list.contains(num)){
                return false;
            }
        }

        return flag;
    }
}
