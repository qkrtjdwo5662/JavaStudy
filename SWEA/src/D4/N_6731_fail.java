package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_6731_fail {
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int[][] changeBoard = new int[n][n];
            int[][] board = new int[n][n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int k = 0; k < s.length(); k++) {
                    if (s.charAt(k) == 'W') {
                        board[j][k] = 0;
                    } else if (s.charAt(k) == 'B') {
                        board[j][k] = 1;
                    }
                }

            }
            answer = Integer.MAX_VALUE;
            boolean[][] visited = new boolean[n][n];
            if(check(board, changeBoard)){
                sb.append("#").append(i).append(" ").append(0).append("\n");
                continue;
            }

            for (int k = 0; k < n; k++) {
                for (int l = 0; l < n; l++) {
                    reverse(board, changeBoard, board[k][l], 1, new int[]{k, l}, visited);
                }
            }
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);

    }
    public static void reverse(int[][] board, int[][] changeBoard, int nowColor, int count, int[] now, boolean[][] visited){
        if(count > answer) return;

        if(check(board, changeBoard)){
            answer = Math.min(answer, count);
            return;
        }

        int n = changeBoard.length;

        int change = -1;
        if(nowColor == 0){
            change = 1;
        }else change = 0;

        for (int i = 0; i < n; i++) {
            changeBoard[now[0]][i] = change;
            changeBoard[i][now[1]] = change;
        }

        changeBoard[now[0]][now[1]] = change;
        visited[now[0]][now[1]] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    reverse(board, changeBoard, board[i][j], count+1, new int[]{i, j}, visited);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            changeBoard[now[0]][i] = nowColor;
            changeBoard[i][now[1]] = nowColor;
        }

        changeBoard[now[0]][now[1]] = nowColor;
        visited[now[0]][now[1]] = false;

    }

    public static boolean check(int[][] board, int[][] changeBoard){
        int n  = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] != changeBoard[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
