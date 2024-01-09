package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_8382 {
    public static int[] rx = {1, -1, 0, 0};
    public static int[] ry = {0, 0, 1, -1};
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

            int dx = Math.abs(x2 - x1);
            int dy = Math.abs(y2 - y1);

            if (dy > dx) {
                int temp = dx;
                dx = dy;
                dy = temp;
            }

            int answer = (dx / 2) * 4 + (dx % 2);

            if (dy % 2 == 1) {
                if (dx % 2 == 1) answer++;
                else answer--;
            }
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }



}
