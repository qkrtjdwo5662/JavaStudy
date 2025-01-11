import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_11265 {
    static Map<Integer, String> answer = new HashMap<>();
    static int n;
    static int m;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        answer.put(0, "Stay here");
        answer.put(1, "Enjoy other party");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];


        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());

                map[i][j] = num;
            }
        }

        for (int k = 1; k <= n ; k++) {
            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <= n ; j++) {
                    // i에서 j를 거쳐 k로 도착
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            int result = map[s][e];

            if(t >= result) sb.append(answer.get(1));
            else sb.append(answer.get(0));

            sb.append("\n");
        }

        System.out.println(sb);

    }
}
