package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_8382_fail {
    public static int[] ry = {0, 0, 1, -1};
    public static int[] rx = {1, -1, 0, 0};

    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int[] start = {x1, y1};
            int[] end = {x2, y2};

            answer = Integer.MAX_VALUE;

            boolean[][] visited = new boolean[201][201];

            visited[x1 + 100][y1 + 100] = true;
            dfs(start, end, 0, 0, visited);
            dfs(start, end, 0, 1, visited);
            visited[x1+100][y1+100] = false;

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int[] now, int[] end, int count, int prev, boolean[][] visited){
        if(count > answer) return;

        if(now[0] == end[0] && now[1] == end[1]){
            answer = Math.min(answer, count);
            return;
        }


        if(prev == 0){
            for (int i = 2; i < 4; i++) {
                int c = now[0] + rx[i];
                int r = now[1] + ry[i];

                if(c + 100 < 0 || r + 100 < 0 || c + 100 > 200 || r + 100 > 200) continue;

                if(!visited[c + 100][r + 100]){
                    visited[c + 100][r + 100] = true;
                    System.out.println(c + " " + r);
                    dfs(new int[]{c, r}, end, count + 1, 1, visited);
                    visited[c + 100][r + 100] = false;
                }

            }

        }else if(prev == 1){
            for (int i = 0; i < 2; i++) {
                int c = now[0] + rx[i];
                int r = now[1] + ry[i];

                if(c + 100 < 0 || r + 100 < 0 || c + 100 > 200 || r + 100 > 200) continue;

                if(!visited[c + 100][r + 100]){
                    visited[c + 100][r + 100] = true;
                    System.out.println(c + " " + r);
                    dfs(new int[]{c, r}, end, count + 1, 0, visited);
                    visited[c + 100][r + 100] = false;
                }

            }
        }

    }
}
