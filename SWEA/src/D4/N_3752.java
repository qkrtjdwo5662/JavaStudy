package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_3752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            int[] scores = new int[n];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int score = Integer.parseInt(st.nextToken());
                scores[j] = score;
            }
            boolean[] visited = new boolean[10001];
            visited[0] = true;
            int max = 0;
            for (int j = 0; j < n; j++) {
                max += scores[j];
                for (int k = max; k >= 0; k--) {
                    if(visited[k]){
                        visited[k + scores[j]] = true;
                    }
                }
            }

            int answer = 0;

            for (int j = 0; j <= 10000 ; j++) {
                if(visited[j]) answer++;
            }
            sb.append("#").append(i).append(" ").append(answer).append("\n");

        }

        System.out.println(sb);
    }

}
