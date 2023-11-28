package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_14361 {
    public static boolean answer;
    public static String[] numArr;
    public static int n;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st  = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            numArr = num.split("");
            n = numArr.length;
            visited = new boolean[n];
            answer = false;
            backtrack(0, "", Integer.parseInt(num));

            if(answer){
                sb.append("#").append(i).append(" ").append("possible").append("\n");
            }else sb.append("#").append(i).append(" ").append("impossible").append("\n");
        }

        System.out.println(sb);
    }

    public static void backtrack(int depth, String s, int num){
        if(answer) return;

        if(depth == n){
            int changeNum = Integer.parseInt(s);
            if(num != changeNum){
                if(changeNum % num == 0) answer = true;
            }
            return;
        }

        for (int i = 0; i <n ; i++) {
            if(!visited[i]){
                visited[i] = true;
                backtrack(depth+1, s+numArr[i], num);
                visited[i] = false;
            }
        }
    }
}
