package D4;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1494_fail_2 {
    public static Point[] earthWarm;
    public static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            earthWarm = new Point[n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                earthWarm[j] = new Point(0, 0);
                earthWarm[j].x = x;
                earthWarm[j].y = y;
            }

            boolean[] visited = new boolean[n];
            answer = Long.MAX_VALUE;
            backtrack(0, 0, n, visited);
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    public static void backtrack(int index, int count, int n, boolean[] visited){
        if(count == n/2){
            int x = 0;
            int y = 0;

            for (int i = 0; i < n; i++) {
                if(visited[i]){
                    y += earthWarm[i].y;
                    x += earthWarm[i].x;
                }else{
                    y -= earthWarm[i].y;
                    x -= earthWarm[i].x;
                }
            }

            answer = Math.min(answer, (long)Math.pow(x, 2) + (long)Math.pow(y, 2));
            return;
        }

        for (int i = index; i < n ; i++) {
            if(!visited[i]){
                visited[i] = true;
                backtrack(index+1, count+1, n, visited);
                visited[i] = false;
            }
        }
    }
}
