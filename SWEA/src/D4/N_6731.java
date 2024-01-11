package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_6731 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            int[][] board = new int[n][n];
            int[] horizontal = new int[n];
            int[] vertical = new int[n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int k = 0; k < s.length(); k++) {
                    if (s.charAt(k) == 'B') {
                        board[j][k] = 1;
                        horizontal[j] ++;
                        vertical[k] ++;
                    }
                }
            }
            int answer = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int count = horizontal[j] + vertical[k];

                    if(board[j][k] == 1) count --; // 해당 칸 블랙이면 한 개 겹침

                    if(count % 2 == 1) answer ++;
                }
            }
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
