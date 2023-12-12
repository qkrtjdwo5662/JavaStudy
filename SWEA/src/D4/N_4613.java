package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_4613 {
    public static char[][] board;
    public static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            board = new char[n][m];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int k = 0; k < m; k++) {
                    board[j][k] = s.charAt(k);
                }
            }
            // 러시아 국기 조건
            // 처음 ~ 끝-2 적어도 1개 하얀색
            // 처음+1 ~ 끝-1 적어도 1개 파란색
            // 나머지 빨간색
            // 하나씩 범위 정해서 넘겨줌
            int answer = Integer.MAX_VALUE;

            for (int j = 0; j < n-2; j++) {
                for (int k = j+1; k < n-1; k++) {
                    int total = count(0, j, 'W') + count(j+1, k, 'B') + count(k+1, n-1, 'R');
                    answer = Math.min(answer, total);
                }
            }
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    public static int count(int start, int end, char color){
        int answer = 0;

        for (int i = start; i <= end ; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] != color) answer++;
            }
        }
        return answer;
    }
}
