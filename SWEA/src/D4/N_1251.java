package D4;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1251 {

    public static int[] parents;
    public static Point[] islands;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 섬의 개수

            parents = new int[n+1];

            for (int j = 1; j <= n ; j++) {
                parents[j] = j;
            }
            islands = new Point[n+1];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) { // x좌표
                int x = Integer.parseInt(st.nextToken());
                islands[j] = new Point(0, 0);
                islands[j].x = x;
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) { // y죄료
                int y = Integer.parseInt(st.nextToken());
                islands[j].y = y;
            }

            st = new StringTokenizer(br.readLine());
            double e = Double.parseDouble(st.nextToken());
            System.out.println(Arrays.toString(islands));
        }
    }
}
